const proxy = [
    {
        context: '/rest',
        target: 'http://localhost:8180/redu/rest',
        pathRewrite: {
            '^/rest': ''
        }
    }
];
module.exports = proxy;
