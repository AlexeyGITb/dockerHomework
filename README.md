Установка постгрес:
helm install pg-db -f kuber/pg/pg.yaml oci://registry-1.docker.io/bitnamicharts/postgresql 
Запуск приложения в кубере:
kubectl apply -f kuber
