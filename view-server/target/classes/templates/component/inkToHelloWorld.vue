<template>
    <div id="vue">Hey, It's Vue! {{ message }}</div>
</template>

<script type="text/javascript">
    export default {
        //这里需要将模块引出，可在其他地方使用
        name: "linkToHelloWorld",
        data (){
            //注意：data即使不需要传数据，也必须return,否则会报错
            return {
                message: "A great expedition!"
            }
        }
    }
</script>

<style type="text/css">
    #vue{
        color: green;
        font-size: 32px;
    }



</style>