function createProduct() {
  let form = document.getElementById("createProduct");

  let productName = form.querySelector("[name=productName]").value;
  let productPrice = form.querySelector("[name=productPrice]").value;

  form.reset();

  req = {
    "name": productName,
    "price": productPrice,
  }

  fetch("/api/create", {
    "method": "POST",
    "body": JSON.stringify(req),
    "header": {
      'Content-Type': 'application/json'
    },
  }).then(
    // TODO
  ).catch(err => {
    // TODO
  });

  console.log(productName, productPrice);
}
