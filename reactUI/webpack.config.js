config = {
   entry: './main.js',
	
   output: {
      path:'/Users/samarth.gupta/Documents/work/modernApplication/shareYourThoughts/src/main/webapp',
      filename: 'index.js',
   },
	
   devServer: {
      inline: true,
      port: 7070
   },
	
   module: {
      loaders: [
         {
            test: /\.jsx?$/,
            exclude: /node_modules/,
            loader: 'babel-loader',            
            query: {
               presets: ['es2015', 'react']
            }
         },{
            test: /\.css?$/,
            loader: "style-loader!css-loader"
         }
      ]
   }
}

module.exports = config;