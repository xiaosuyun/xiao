// 公共方法 -- 处理html标签显示界面
export function removeHtmlTag(htmlStr) {
    let html = htmlStr
        .replace(/<img.*?>/g, "[图片]")
        .replaceAll(/<[^>]+>/g, "")
        .replace(/&nbsp;/gi, "")
    return html;
}
