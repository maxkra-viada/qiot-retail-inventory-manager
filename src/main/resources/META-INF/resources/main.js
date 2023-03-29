function createProduct() {
  let form = document.getElementById("createProduct");

  let productName = form.querySelector("[name=productName]").value;
  let productPrice = form.querySelector("[name=productPrice]").value;

  form.reset();

  req = {
    "title": productName,
    "priceInCents": productPrice,
  }

  fetch("/api/product", {
    "method": "POST",
    "body": JSON.stringify(req),
    "header": {
      'Content-Type': 'application/json'
    },
  }).then(() => {
    document.getElementById("createSuccess").className = "";
    document.getElementById("createFailed").className = "hidden";
  }
  ).catch(() => {
    document.getElementById("createFailed").className = "";
    document.getElementById("createSuccess").className = "hidden";
  });

  console.log(productName, productPrice);
}

function getProducts() {
  let list = document.getElementById("productList");

  fetch("/api/product/all", {
    "method": "GET",
    "header": {
      'Content-Type': 'application/json'
    },
  }).then((response) => {
    response.array.forEach(element => {
      let li = document.createElement('li');
      li.innerHTML = element.title + ": " + element.priceInCents;
      list.appendChild(li);
    });
  }
  ).catch(() => {});

  console.log(productName, productPrice);
}
