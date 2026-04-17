let fingerprintId = "";

window.onload = async function () {
  console.log("Page loaded");

  try {
    // Dynamically load FingerprintJS
    const fpPromise = import('https://openfpcdn.io/fingerprintjs/v3');

    const FingerprintJS = await fpPromise;
    console.log("Library loaded");

    const fp = await FingerprintJS.load();
    console.log("FP instance created");

    const result = await fp.get();
    console.log("Result:", result);

    fingerprintId = result.visitorId;

    console.log("Fingerprint ID:", fingerprintId);

    // Enable button
    document.getElementById("trackBtn").disabled = false;

    // Send page view
    sendData("page_view");

  } catch (error) {
    console.error("Fingerprint error:", error);
  }
};

function sendData(eventType) {
  fetch("http://localhost:8080/api/track", {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify({
      fingerprintId: fingerprintId,
      event: eventType,
      url: window.location.href,
      timestamp: new Date()
    })
  })
  .then(res => res.json())
  .then(data => console.log("Sent:", data))
  .catch(err => console.error("Error:", err));
}

function trackClick() {
  if (!fingerprintId) {
    console.log("Fingerprint not ready");
    return;
  }
  sendData("click");
}
function loadData() {
  fetch("http://localhost:8080/api/events")
    .then(res => res.json())
    .then(data => {

      const counts = {};

      data.forEach(item => {
        counts[item.fingerprintId] = (counts[item.fingerprintId] || 0) + 1;
      });

      const list = document.getElementById("dataList");
      list.innerHTML = "";

      for (let id in counts) {
        const li = document.createElement("li");
        li.innerHTML = `<b>${id}</b> → ${counts[id]} actions`;
        list.appendChild(li);
      }
    });
}