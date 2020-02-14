vue = new Vue({
    el: '#app',
    data: {
        searchKey: "",
        menus: [],
        projects: []
    }
});

/* 避免样式闪动 */
window.onload = function () {
    let datasourceId = document.getElementById("datasouce");
    datasourceId.style.display = "none";
    document.getElementById("app").style.display = "block";

    // let vue={menus:[],projects:[]}

    let children = datasourceId.children;
    for (let i = 0; i < children.length; i++) {
        let child = children[i];
        if (child.className == 'menu') {
            let menuList = child.children;

            vue.menus = []
            for (let i = 0; i < menuList.length; i++) {
                let menu = menuList[i];
                vue.menus[i] = {
                    icon: menu.getAttribute('data-icon'),
                    href: menu.getAttribute('href'),
                    text: menu.text
                }
            }

        } else if (child.className == 'project') {
            let projectList = child.children;
            vue.projects = []
            for (let i = 0; i < projectList.length; i++) {
                let project = projectList[i];
                vue.projects[i] = {
                    image: project.getAttribute('data-image'),
                    url: project.getAttribute('href'),
                    name: project.text
                }
            }


        }
    }

};
