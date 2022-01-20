<!-- chartjs -->

<script>
 /*  const labels12 = [
    '2018.12.',
    '2019.12',
    '2020.12',
    '2021.12',
  ];
  const data4 = {
		  labels: labels12,
		  datasets: [
		    {
		      label: '매출액',
		      data: [24170,30701,41568,60942]
		      backgroundColor: 'rgb(255, 99, 132)',
		      borderColor: 'rgb(255, 99, 132)',
		    },
		    {
		      label: '영업이익',
		      data: [729,2068,4559,6666]
		      backgroundColor: 'rgb(0, 123, 255)',
		      borderColor: 'rgb(0, 123, 255)',
		    },
		    {
		      label: '당기순이익',
		      data: [159,-3419,1734,16608]
		      backgroundColor: 'rgb(108, 189, 191)',
		      borderColor: 'rgb(108, 189, 191)',
		    },
		    {
			      label: '지배주주순이익',
			      data: [479,-3010,1556,0]
			      backgroundColor:'rgb(255, 99, 132)',
			      borderColor:'rgb(255, 99, 132)',
			    },
			    {
				      label: '비지배주주순이익',
				      data: [-320,-409,177,0]
				      backgroundColor:'rgb(0, 123, 255)',
				      borderColor:'rgb(0, 123, 255)',
				    },
		  ]
		};
  const config3 = {
		  type: 'bar',
		  data: data4,
		  options: {
		    plugins: {
		    	legend:{
	        		display:false,
	        	},
		      title: {
		        display: false,
		      },
		    },
		    responsive: true,
		    }
		}; */
 /*  const actions = [
	  {
	    name: 'Randomize',
	    handler(chart) {
	      chart.data.datasets.forEach(dataset => {
	        dataset.data = Utils.numbers({count: chart.data.labels.length, min: -100, max: 100});
	      });
	      chart.update();
	    }
	  },
	]; */
</script>
<script>
var ctx = document.getElementById('myChart2').getContext('2d'); 
var chart = new Chart(ctx, { // type : 'bar' = 막대차트를 의미합니다.
	type: 'bar', //
    options: {
        plugins: {
        	legend:{
        		display:false,
        	},
          title: {
            display: false,
          }
        }
    },
	data: { 
		labels: [ '2018.12.',
		    '2019.12',
		    '2020.12',
		    '2021.12'], // 큰 분류(하단 데이터 이름) 
		datasets: [ { 
			label: '매출액', //작은 분류
			backgroundColor:  'rgb(255, 99, 132)',
			borderColor:  'rgb(255, 99, 132)',
			data: [6710,7001,11168,8042] },
			{ label:'영업이익', //작은 분류
			backgroundColor: 'rgb(0, 123, 255)',
			borderColor: 'rgb(0, 123, 255)',
			  data: [3729,5068,8559,6666] },
			{ label: '당기순이익', //작은 분류
			backgroundColor: 'rgb(108, 189, 191)',
			borderColor:'rgb(108, 189, 191)',
			data: [2159,-3419,3734,6608] },
			{ label: '지배주주순이익', //작은 분류
			backgroundColor: '#8F63E8',
			borderColor: '#8F63E8',
			data: [2479,-3010,3556,1120] },
			{ label: '비지배주주순이익', //작은 분류
				backgroundColor: '#647BCD',
				borderColor: '#647BCD',
				data:  [-1320,-1409,6277,2440] },
			] },
		});

</script>
