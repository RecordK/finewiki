<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- REQUIRED SCRIPTS -->
<!-- jQuery -->
<script src="${path}/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="${path}/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="${path}/dist/js/adminlte.min.js"></script>
<!-- HandleBars JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.0.11/handlebars.min.js"></script>

<script src="${path}/plugins/ekko-lightbox/ekko-lightbox.js"></script>
<!-- AdminLTE App -->
<script src="${path}/dist/js/pages/dashboard3.js"></script>
<!-- OPTIONAL SCRIPTS -->
<script src="${path}/plugins/chart.js/Chart.min.js"></script>
<script src="${path}/plugins/chart.js/Chart.js"></script>
<script src="${path}/plugins/chart.js/Chart.bundle.min.js"></script>
<script src="${path}/plugins/chart.js/Chart.bundle.js"></script>
<script src="${path}/plugins/chart.js/utils.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<!-- chartjs -->

<script>
  const labels = [
    '1st',
    '10th',
    '15th',
    '20th',
    '25th',
    '30th',
  ];
  const data = {
		  labels: labels,
		  datasets: [
		    {
		    	 data: [3000.00, 2940.00,2910.00 , 2930.00, 2860.00, 2850.00, 2840.00],
		      borderColor:  'rgb(0, 123, 255)',
		      backgroundColor:'rgb(0, 123, 255)',
		      yAxisID: 'y',
		    },
		    {
		      data:  [2860.00, 2920.00,2980.00 , 2960.00, 2980.00, 3010.00, 3000.00],
		      borderColor: 'rgb(255, 99, 132)',
		      backgroundColor: 'rgb(255, 99, 132)',
		      yAxisID: 'y1',
		    }
		  ]
		};
  const labels2 = [
	    '3rd',
	    '4th',
	    '5th',
	    '6th',
	    '7th',
	    '10th',
	    '11st',
	    '12nd',
	    '13rd',
	    '14th',
	    '17th',
	  ];
  const config = {
    type: 'line',
    data: data,
    options: {
        responsive: true,
        interaction: {
          mode: 'index',
          intersect: false,
        },
        stacked: false,
        plugins: {
        	legend:{
        		display:false,
        	},
          title: {
            display: false,
          }
        },
        scales: {
          y: {
            type: 'linear',
            display: true,
            position: 'left',
          },
          y1: {
            type: 'linear',
            display: false,
            position: 'right',

            // grid line settings
            grid: {
              drawOnChartArea: false, // only want the grid lines for one axis to show up
            },
          },
        }
      },
    };
  const data2 = {
		  labels: labels2,
		  datasets: [
		    {
		    	 data: [114500, 111500,105500 , 100000, 100000, 96600, 95000,97200,96700,93900,92900],
		      borderColor:  'rgb(0, 123, 255)',
		      backgroundColor:'rgb(0, 123, 255)',
		      yAxisID: 'y',
		    },
		  ]
		};
  const config2 = {
		    type: 'line',
		    data: data2,
		    options: {
		        responsive: true,
		        interaction: {
		          mode: 'index',
		          intersect: false,
		        },
		        stacked: false,
		        plugins: {
		        	legend:{
		        		display:false,
		        	},
		          title: {
		            display: false,
		          }
		        },
		        }
		    };

</script>
<script>
  const myChart = new Chart(
    document.getElementById('myChart'),
    config
  );
  /* const myChart2 = new Chart(
		    document.getElementById('myChart2'),
		    config2
		  ); */
</script>
 