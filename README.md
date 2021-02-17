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

