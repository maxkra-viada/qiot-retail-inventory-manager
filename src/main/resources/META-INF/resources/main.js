class InventoryUI {
  constructor() {
    document.addEventListener('click', () => {
      document.getElementById("createSuccess").className = "hidden";
      document.getElementById("createFailed").className = "hidden";
    });
  }

  createProduct() {
    let form = document.getElementById("createProduct");

    let productName = form.querySelector("[name=productName]").value;
    let productPrice = form.querySelector("[name=productPrice]").value;
    let quantity = form.querySelector("[name=quantity]").value;

    form.reset();

    req = {
      "title": productName,
      "priceInCents": parseInt(productPrice*100),
      "quantity": quantity,
    }

    fetch("/api/product", {
      "method": "POST",
      "body": JSON.stringify(req),
      "header": {
        'Content-Type': 'application/json'
      },
    }).then(() => {
      document.getElementById("createSuccess").className = "";
    }
    ).catch(() => {
      document.getElementById("createFailed").className = "";
    });

    console.log(productName, productPrice);

    this.getProducts();
  }

  getProducts() {
    let list = document.getElementById("productList");

    fetch("/api/product/all", {
      "method": "GET",
      "header": {
        'Content-Type': 'application/json'
      },
    }).then((response) => {
      response.array.forEach(element => {
        let li = document.createElement('li');
        li.innerHTML = element.quantity + "x " + element.title + " ("
            + Number.parseFloat(element.priceInCents/100).toFixed(2) + "€)";
        list.appendChild(li);
      });
    }
    ).catch(() => {});

    console.log(productName, productPrice);
  }

}
