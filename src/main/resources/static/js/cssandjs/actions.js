const FSAPI = "A4TFVB6yBQSiutacj1pDnz"
const client = filestack.init(FSAPI);
var imageHandle = ''
var transformURL = "https://cdn.filestackcontent.com/watermark=file:";
var watermarkHandle = '';

function openPicker() {
    console.log("open Water Picker");
    client.pick({
        accept: 'image/*',
        maxFiles: 1,
    }).then(function(result) {
        console.log(JSON.stringify(result));
        watermarkHandle = result.filesUploaded[0].handle;
        console.log(watermarkHandle);
    })
}

function openPhotoPicker() {
    console.log("blah blah blah");
    console.log("open Photo Picker");
    client.pick({
        accept: 'image/*',
        maxFiles: 1,
    }).then(function (result) {
        console.log(JSON.stringify(result));
        imageHandle = result.filesUploaded[0].url;
        console.log(imageHandle);
    }).then(function () {
        $(".postImages").append("<input type='hidden' name='imageUrl' value='" + imageHandle + "'>");

    })
    json_data = {imageHandle}
    var postImages = document.createElement("img");
    postImages.onload = function() {
        document.getElementById("postImages").appendChild(postImages);
    }
    postImages.src = imageHandle;

    function buildURL() {
        transformURL += watermarkHandle;
        //Puts watermark in the center with a size 200
        transformURL += ',position:[middle,center],size:200/'
        transformURL += imageHandle;
        console.log(transformURL);
    }

    function storePhoto() {
        console.log("storeurl");
        client.storeURL(transformURL).then(function (result) {
            console.log('Store URL');
            console.log(JSON.stringify(result));
            document.getElementById("Download Picture").href = result.url;
        })
    }
}

