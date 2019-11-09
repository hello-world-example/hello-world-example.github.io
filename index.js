new Vue({
    el: '#app',
    data: {
        searchKey: "",
        menus: [
            {
                icon: "el-icon-s-home",
                href: "//kail.xyz",
                text: "Home"
            },
            {
                icon: "el-icon-edit-outline",
                href: "//blog.kail.xyz",
                text: "Blog"
            },
            {
                icon: "el-icon-magic-stick",
                href: "//github.com/kailbin",
                text: "Github"
            }
        ],
        projects: [
            {
                name: "Java",
                url: "//kail.xyz/Java",
                image: "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1573304467632&di=75bd40dedc7b361243d6e3e5cd993637&imgtype=0&src=http%3A%2F%2Fs15.sinaimg.cn%2Fmw690%2F006UXnVgzy7hOeKADjo4e%26690"
            },
            {
                name: "Docker",
                url: "//kail.xyz/Docker",
                image: "http://img4.imgtn.bdimg.com/it/u=1037767819,3957627469&fm=26&gp=0.jpg"
            },
            {
                name: "Spring",
                url: "//kail.xyz/Spring",
                image: "http://img4.imgtn.bdimg.com/it/u=2995354372,2168828254&fm=26&gp=0.jpg"
            },
            {
                name: "Kafka",
                url: "//kail.xyz/Kafka",
                image: "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1573315426586&di=6c3c8984607d44e3cb588ccb4ca95817&imgtype=0&src=http%3A%2F%2Fwww.instaclustr.com%2Fwp-content%2Fuploads%2F2017%2F05%2Fapache-kafka-640x640.png"
            },
            {
                name: "FreeMarker",
                url: "//kail.xyz/FreeMarker",
                image: "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2725454846,1665261921&fm=26&gp=0.jpg"
            }
        ]
    }
});

/* 避免样式闪动 */
window.onload = function () {
    document.getElementById("app").style.display = "block";
};
