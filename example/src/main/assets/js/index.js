$(function () {
    $('.share').click(function () {
        var json = {
            action: "share",
            params: {
                imageUrl:"https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3102711909,683345632&fm=27&gp=0.jpg",
                url:"https://www.baidu.com",
                title:"标题",
                text:"描述"
            }
        };

        latte.event(JSON.stringify(json));

    });

    $('.comment').click(function () {

            var json = {
                action: "comment"
            };

            latte.event(JSON.stringify(json));

        });
});