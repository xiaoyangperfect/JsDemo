/// <reference path="jquery-1.8.3.js" />


var Test = {
    Init: function () {
        this.Action();
    },
    Action: function () {
        var t = this;
        $("#upload").click(function () {
        });

        $("#exist").click(function () {

           t.ajsx1("");
        });
    },

    //http://localhost:2308/main/Products
    ajsx2: function (file) {
        var xhr = new XMLHttpRequest();
        var data = new FormData();

        // data.append("fileToUpload", file); 
        // url: 'http://localhost:7145/api/FileUpload', 
        // url: 'http://192.168.1.13/api/api/FileUpload',
        data.append("FromUrl", "http://ddiaosi.cn");
        data.append("Description", "input/ ");
        data.append("KeyWords", "a.2.3.4.5.6");
        data.append("Class", "ce shi");

        data.append("FileFlag", "ce shi");
        data.append("Path", "D:\\Picture");
        data.append("DownloadLink", "ce shi");
        data.append("FileName", "113.jpg");
        data.append("FileTime", "ce shi");
        //var data = {"FromUrl":"sfddsafasdf"}
        xhr.open("post", 'http://192.168.1.22:3000/FileUpload', true);
        xhr.onload = function () {
            alert("上传完成!");
        };
        xhr.send(data);
    },

    ajsx1: function (file) {
        var xhr = new XMLHttpRequest();
        var data = new FormData();
        data.append("link", file);
        xhr.open("post", 'http://192.168.1.27:3000/IsExisitFileByLink', true);
        xhr.onload = function () {
            // alert("上传完成!");
        };
        xhr.send(data);
    }
}