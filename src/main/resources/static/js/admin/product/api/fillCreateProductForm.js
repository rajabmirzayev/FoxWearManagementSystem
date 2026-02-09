async function fillCreateProductForm() {
    const gender = document.getElementById("gender");
    const purpose = document.getElementById("purpose");
    const season = document.getElementById("season");
    const type = document.getElementById("wearType");
    const size = document.getElementById("size");

    await fetch("/api/enums/wear-gender")
        .then(res => res.json())
        .then(json => json.data)
        .then(data => {
            data.forEach(g => {
                let option = document.createElement("option");
                option.value = g.id;
                option.text = g.name;
                gender.appendChild(option);
            });
        });

    await fetch("/api/enums/wear-purpose")
        .then(res => res.json())
        .then(json => json.data)
        .then(data => {
            data.forEach(p => {
                let option = document.createElement("option");
                option.value = p.id;
                option.text = p.name;
                purpose.appendChild(option);
            });
        });

    await fetch("/api/enums/wear-season")
        .then(res => res.json())
        .then(json => json.data)
        .then(data => {
            data.forEach(s => {
                let option = document.createElement("option");
                option.value = s.id;
                option.text = s.name;
                season.appendChild(option);
            });
        });

    await fetch("/api/enums/wear-type")
        .then(res => res.json())
        .then(json => json.data)
        .then(data => {
            data.forEach(t => {
                let option = document.createElement("option");
                option.value = t.id;
                option.text = t.name;
                type.appendChild(option);
            });
        });

    await fetch("/api/enums/wear-size")
        .then(res => res.json())
        .then(json => json.data)
        .then(data => {
            data.forEach(s => {
                let option = document.createElement("option");
                option.value = s.id;
                option.text = s.name;
                size.appendChild(option);
            })
        })
}

fillCreateProductForm();