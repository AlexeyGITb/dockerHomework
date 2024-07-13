Установка постгрес:

helm install pg-db -f kuber/pg/pg.yaml oci://registry-1.docker.io/bitnamicharts/postgresql 

Запуск приложения в кубере:

kubectl apply -f kuber

Установка Prometheus:

helm install stack prometheus-community/kube-prometheus-stack -f kuber\prometheus\prometheus.yaml
