# DonateYourBooks

How to run the project 

mvn clean install
mvn spring-boot:run

http://localhost:9090/books

http://localhost:9090/h2-console/

See Swagger API Documentation here http://localhost:9090/swagger-ui.html#

API docs will be available here http://localhost:9090/v2/api-docs

Refered for security:
https://spring.io/guides/topicals/spring-security-architecture/

https://spring.io/guides/gs/securing-web/

OAuth 
https://auth0.com/blog/implementing-jwt-authentication-on-spring-boot/



docker tag donateyourbooks:latest narendrakareli/donateyourbooks
docker push narendrakareli/donateyourbooks

kubectl create deployment donateyourbooks --image=narendrakareli/donateyourbooks:latest --dry-run=client -o=yaml > deployment.yaml
echo --- >> deployment.yaml
kubectl create service clusterip donateyourbooks --tcp=9090:9090 --dry-run=client -o=yaml >> deployment.yaml

kubectl apply -f deployment.yaml
deployment.apps/demo created
service/demo created


kubectl port-forward svc/donateyourbooks 9090:9090


kubectl describe pod donateyourbooks-58d994f7bd-9wm6k


curl $(minikube service donateyourbooks --url)/api/book

curl http://192.168.49.2:30626/health

kubectl get all   (to get all the information posd services and deployment)

if 8080 not work make sure our application exposed on 9090

here you go and change the port
kubectl edit svc donateyourbooks

minikube start --driver=docker


minikube dashboard


docker run -p 8080:8080 narendrakareli/donateyourbooks:latest

kubectl create deployment donateyourbooks --image=narendrakareli/donateyourbooks:latest


kubectl expose deployment donateyourbooks --type=LoadBalancer --port=9090

kubectl scale deployment donateyourbooks --replicas=3


kubectl delete pod donateyourbooks-6dd55f4485-nq8nk

kubectl autoscale deployment donateyourbooks--max=10 --cpu-percent=70

kubectl edit deployment donateyourbooks #minReadySeconds: 15

kubectl set image deployment donateyourbooks donateyourbooks=narendrakareli/donateyourbooks:latest


kubectl set image deployment donateyourbooks donateyourbooks=DUMMY_IMAGE:TEST

kubectl get events --sort-by=.metadata.creationTimestamp

kubectl set image deployment hello-world-rest-api hello-world-rest-api=narendrakareli/donateyourbooks:latest
kubectl get events --sort-by=.metadata.creationTimestamp

kubectl get componentstatuses

kubectl get pods --all-namespaces

kubectl get events

kubectl get pods

kubectl get replicaset

kubectl get deployment

kubectl get service

kubectl get pods -o wide

kubectl explain pods

kubectl get pods -o wide

kubectl describe pod donateyourbooks-6dd55f4485-gz2zw

kubectl get replicasets

kubectl get replicaset

kubectl scale deployment donateyourbooks --replicas=3

kubectl get pods

kubectl get replicaset

kubectl get events


kubectl get events --sort-by=.metadata.creationTimestamp

kubectl get rs

kubectl get svc --watch

kubectl get deployments

kubectl get deployment donateyourbooks -o yaml >> deployment.yaml 
kubectl get service donateyourbooks -o yaml >> service.yaml 

kubectl diff -f deployment.yaml
kubectl apply -f deployment.yaml

kubectl delete all -l app=donateyourbooks

kubectl rollout history deployment donateyourbooks

kubectl rollout undo deployment donateyourbooks --to-revision=1

kubectl logs donateyourbooks-6dd55f4485-4cdsw

kubectl logs -f donateyourbooks-6dd55f4485-4cdsw

kubectl autoscale deployment donateyourbooks --min=1 --max=3 --cpu-percent=5 

kubectl get hpa

kubectl top pod
kubectl top nodes
kubectl get hpa
kubectl delete hpa donateyourbooks

kubectl config view

kubectl get configmap

kubectl get configmap donateyourbooks-o yaml >> configmap.yaml



