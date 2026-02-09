async function sendCreateProductRequest() {
    const form = document.getElementById("createProductForm");
    form.addEventListener("submit", async function (event) {
        event.preventDefault();

        const name = document.getElementById("name").value;
        const discount = document.getElementById("discount").value;
        const gender = document.getElementById("gender").value;
        const purpose = document.getElementById("purpose").value;
        const season = document.getElementById("season").value;
        const wearType = document.getElementById("wearType").value;
        const description = document.getElementById("description").value;

        const colorName = document.getElementById("colorName").value;
        const stockQuantity = document.getElementById("stockQuantity").value;
        const price = document.getElementById("price").value;
        const size = document.getElementById("size").value;
        const image = document.getElementById("imageUrl").value;

        const bodyProduct = {
            name,
            discount,
            gender,
            purpose,
            season,
            wearType,
            description
        }

        let id;

        await fetch("/api/product", {
            method: "POST",
            body: JSON.stringify(bodyProduct),
            headers: {
                "Content-Type": "application/json",
            }
        })
        .then(res => res.json())
        .then(json => json.data)
        .then(data => {
            id = data.id;
        });

        const bodyColor = {
            colorName,
            stockQuantity,
            price,
            size,
            product: {
                id: id,
            },
            image
        }

        console.log("body: " + JSON.stringify(bodyColor));

        await fetch("/api/color", {
            method: "POST",
            body: JSON.stringify(bodyColor),
            headers: {
                "Content-Type": "application/json",
            }
        });

        event.target.reset();
    });
}
sendCreateProductRequest().then(() => {});