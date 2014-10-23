echo "No. of connections: 1, 200, 400, ..., 5000"
for j in {1..10}
do
	/usr/local/go/bin/go run client.go -numb=1 >> result
done

for i in {1..25}
do
	let z=i*200
	for j in {1..10}
	do
		/usr/local/go/bin/go run client.go -numb=$z >> result
	done
done
