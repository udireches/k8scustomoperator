package io.fabric8.podset.operator.controller;

import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinition;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionBuilder;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.dsl.base.CustomResourceDefinitionContext;
import io.fabric8.podset.operator.model.v1alpha1.PodSet;
import io.fabric8.podset.operator.model.v1alpha1.PodSetList;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;

public class PodsetCreateDefinitionTest {


  /*
  @Test
  public void createPodsetCustomResource() {
    KubernetesClient kubernetesClient = new DefaultKubernetesClient();

    //Nee to add all the details of the schema etc. BUT much easier to create from the YAML as in createPodsetCustomResource2 below
    CustomResourceDefinitionBuilder b = CustomResourceDefinitionContext.v1CRDFromCustomResourceType(PodSet.class);
    CustomResourceDefinition d = b.withNewSpec().addNewVersion().withNewSchema().endSchema().endVersion().endSpec().build();
    kubernetesClient.resource(d).createOrReplace();
  }

   */

  // Test the creation of a CRD definition object and the creation of the CRD in the cluster
  //See https://itnext.io/customresource-improvements-in-fabric8-kubernetesclient-v5-0-0-4aef4d299323
  @Test
  public void createPodsetCustomResource2() {
    try {


      KubernetesClient client = new DefaultKubernetesClient();
      CustomResourceDefinition crd = client.apiextensions().v1().customResourceDefinitions()
          .load(new FileInputStream("src/main/resources/crd.yaml"))
          .get();
      client.apiextensions().v1().customResourceDefinitions().createOrReplace(crd);
      //Or use client.resource(crd).createOrReplace();
    } catch (Exception e) {
      e.printStackTrace();
    }

  }



}
