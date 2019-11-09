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
                name: "kaka",
                url: "1",
                image: ""
            },
            {
                name: "Java",
                url: "1",
                image: ""
            },
            {
                name: "Java",
                url: "1",
                image: ""
            }
        ]
    }
});

/* 避免样式闪动 */
window.onload = function () {
    document.getElementById("app").style.display = "block";
};
