

      const url_no_filter = "./students";

const vm = new Vue({
        el: '#app',
        data: {
          results: [],
          checked:false
        },
         watch: {
        checked: 'foo'
         },
       methods: {
        foo: function(){
            //alert(this.checked);
            var url = url_no_filter;
            if (this.checked){
              url += "?filterLimitGrade=10"
            }

             axios.get(url).then(response => {
               this.results = response.data;
          }).catch(error => {
             alert(error.response.data.message)
          });
          }
     },
        mounted() {
          axios.get(url_no_filter).then(response => {
            this.results = response.data
          })
        }
      });