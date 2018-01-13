package hex.schemas;

import hex.Model;
import water.api.API;
import water.api.schemas3.SchemaV3;

public class InteractionSpecPairV3 extends SchemaV3<Model.InteractionSpecPair, InteractionSpecPairV3> {
  @API(help = "Column A")
  String column_a;
  @API(help = "Column B")
  String column_b;
}
