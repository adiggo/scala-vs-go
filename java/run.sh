for i in {1..1}
do
	java Server &
	java Client 4 >> result
	kill `lsof -i:1201 -t`
done

for i in {1..10}
do
	let z=400*$i
	for j in {1..1}
	do
		java Server &
		java Client $z >> result
		kill `lsof -i:1201 -t`
	done 
done
