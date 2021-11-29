package io.fabric8.podset.operator.controller;

import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinition;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionBuilder;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.dsl.base.CustomResourceDefinitionContext;
import io.fabric8.podset.operator.model.v1alpha1.PodSet;
import io.fabric8.podset.operator.model.v1alpha1.PodSetList;
import org.junit.Test;

public class PodsetCreateDefinitionTest {

  // Test the creation of a CRD definition object and the creation of the CRD in the cluster
  @Test
  public void reatePodsetCustomResource() {
    KubernetesClient kubernetesClient = new DefaultKubernetesClient();
    CustomResourceDefinitionBuilder b = CustomResourceDefinitionContext.v1CRDFromCustomResourceType(PodSet.class);
    CustomResourceDefinition d = b.build();
    kubernetesClient.resource(d).createOrReplace();
  }
}
