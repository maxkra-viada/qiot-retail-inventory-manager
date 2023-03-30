// initial calls

document.addEventListener("click", () => {
  document.getElementById("createSuccess").className = "hidden";
  document.getElementById("createFailed").className = "hidden";
});

document.addEventListener("DOMContentLoaded", this.getProducts);

// function definitions

function createProduct() {
  const form = document.getElementById("createProduct");

  const productName = form.querySelector("[name=productName]").value;
  const productPrice = form.querySelector("[name=productPrice]").value;
  const quantity = form.querySelector("[name=productQuantity]").value;

  form.reset();

  request = {
    "title": productName,
    "priceInCents": parseInt(productPrice*100),
    "quantity": +quantity,
  }

  fetch("/api/product", {
    "method": "POST",
    "body": JSON.stringify(request),
    "headers": {
      "Content-Type": "application/json",
    },
  })
  .then(response => response.ok ? response.json() : Promise.reject(response))
  .then(_ => {
    console.log("created product: ",request);
    document.getElementById("createSuccess").className = "";
  }
  ).catch(_ => {
    console.log("couldnt create product: ",request);
    document.getElementById("createFailed").className = "";
  });

  this.getProducts();
}

function getProducts() {
  const list = document.getElementById("productList");

  fetch("/api/product/all", {
    "method": "GET",
    "headers": {
      "Content-Type": "application/json",
    },
  })
  .then(response => response.json())
  .then(data => {
    list.innerHTML = "";
    data?.forEach(element => {
      const li = document.createElement('li');
      list.appendChild(li);
      li.innerHTML = element.quantity + "x " + element.title + " ("
          + Number.parseFloat(element.priceInCents/100).toFixed(2) + "€)";
    });
  });
}
