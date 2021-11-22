package test;

import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;

public class TestAPI {
  public static void main(String[] args) {
    try (KubernetesClient client = new DefaultKubernetesClient()) {
      //client.namespaces().list().getItems().forEach(System.out::println);
      //client.pods().list().getItems().forEach(System.out::println);
      client.pods().list().getItems().forEach(p -> System.out.println(p.getMetadata().getName() + " " + p.getMetadata().getNamespace()));


    }
  }
}