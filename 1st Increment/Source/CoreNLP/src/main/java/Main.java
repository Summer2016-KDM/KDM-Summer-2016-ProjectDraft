import edu.stanford.nlp.hcoref.CorefCoreAnnotations;
import edu.stanford.nlp.hcoref.data.CorefChain;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.semgraph.SemanticGraph;
import edu.stanford.nlp.semgraph.SemanticGraphCoreAnnotations;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.TreeCoreAnnotations;
import edu.stanford.nlp.util.CoreMap;

import java.util.List;
import java.util.Map;
import java.util.Properties;


/**
 * Created by Mayanka on 13-Jun-16.
 */
public class Main {
    public static void main(String args[]) {
        // creates a StanfordCoreNLP object, with POS tagging, lemmatization, NER, parsing, and coreference resolution
        Properties props = new Properties();
        props.setProperty("annotators", "tokenize, ssplit, pos, lemma, ner, parse, dcoref");
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);

// read some text in the text variable
        String text = "\"NAME DESCRIPTION ALL       TA+ Norel ALL     TA+ (ML) Norel ALL      Norel ALL      TA  Norel ALL       TA  Norel ALL       TA  Norel ALL R   (ML) Relap ALL      ML ALL      ML ALL      ML ALL      ML ALL      ML ALL      ML ALL      TA+ (ML) Norel ALL      TA+ (ML) Norel ALL      TA  (ML) Norel ALL      TA  (ML) Norel ALL     TA  (ML) Norel ALL SH   ALL SH    ALL SH    AML    (PK) Norel AML    (PK) Norel AML    (PK) Relap AML   (PK) Relap AML SH   AML SH    AML SH    AML SH    AML SH    AML    ML AML    ML AML    (ML) AML    (ML) AML   (ML) Relap\\n\" +\n" +
                "                \"ALPPL  ALPPL :alkaline phosphatase, placental like                                                                                                                                                                                   \\n\" +\n" +
                "                \"RPLP  RPLP :ribosomal protein, large, P                                                                                                                                                                                                                                                      \\n\" +\n" +
                "                \"GFER GFER:growth factor, augmenter of liver regeneration (ERV  homolog, S  cerevisiae)                                                                                                                                                                            \\n\" +\n" +
                "                \"IGHM IGHM:immunoglobulin heavy constant mu                                                                                                                                                                                                                       \\n\" +\n" +
                "                \"SART  SART :squamous cell carcinoma antigen recognised by T cells                                                                                                                                                                              \\n\" +\n" +
                "                \"RPLP  RPLP :ribosomal protein, large, P                                                                                                                                                                                                                                                      \\n\" +\n" +
                "                \"RPLP  RPLP :ribosomal protein, large, P                                                                                                                                                                                                                                                      \\n\" +\n" +
                "                \"PDHA  PDHA :pyruvate dehydrogenase (lipoamide) alpha                                                                                                                                                 \\n\" +\n" +
                "                \"OGT OGT:O linked N acetylglucosamine (GlcNAc) transferase (UDP N acetylglucosamine:polypeptide N acetylglucosaminyl transferase)                                                                                                                                                                             \\n\" +\n" +
                "                \"PDHA  PDHA :pyruvate dehydrogenase (lipoamide) alpha                                                                                                                                                                                     \\n\" +\n" +
                "                \"CYP D P  /// CYP D  na                                                                                                                                                                                   \\n\" +\n" +
                "                \"ACAA  ACAA :acetyl Coenzyme A acyltransferase   (mitochondrial   oxoacyl Coenzyme A thiolase)                                                                                                                                                                          \\n\" +\n" +
                "                \"TMEFF  TMEFF :transmembrane protein with EGF like and two follistatin like domains                                                                                                                                                             \\n\" +\n" +
                "                \"LRRC  LRRC :leucine rich repeat containing "; // Add your text here!

// create an empty Annotation just with the given text
        Annotation document = new Annotation(text);

// run all Annotators on this text
        pipeline.annotate(document);

        // these are all the sentences in this document
// a CoreMap is essentially a Map that uses class objects as keys and has values with custom types
        List<CoreMap> sentences = document.get(CoreAnnotations.SentencesAnnotation.class);

        for (CoreMap sentence : sentences) {
            // traversing the words in the current sentence
            // a CoreLabel is a CoreMap with additional token-specific methods
            for (CoreLabel token : sentence.get(CoreAnnotations.TokensAnnotation.class)) {

                System.out.println("\n" + token);

                // this is the text of the token
                String word = token.get(CoreAnnotations.TextAnnotation.class);
                System.out.println("Text Annotation");
                System.out.println(token + ":" + word);
                // this is the POS tag of the token

                String lemma = token.get(CoreAnnotations.LemmaAnnotation.class);
                System.out.println("Lemma Annotation");
                System.out.println(token + ":" + lemma);
                // this is the Lemmatized tag of the token


                String pos = token.get(CoreAnnotations.PartOfSpeechAnnotation.class);
                System.out.println("POS");
                System.out.println(token + ":" + pos);

                // this is the NER label of the token
                String ne = token.get(CoreAnnotations.NamedEntityTagAnnotation.class);
                System.out.println("NER");
                System.out.println(token + ":" + ne);

                System.out.println("\n\n");
            }

            // this is the parse tree of the current sentence
            Tree tree = sentence.get(TreeCoreAnnotations.TreeAnnotation.class);
            System.out.println(tree);
            // this is the Stanford dependency graph of the current sentence
            SemanticGraph dependencies = sentence.get(SemanticGraphCoreAnnotations.CollapsedCCProcessedDependenciesAnnotation.class);
            System.out.println(dependencies.toString());

            Map<Integer, CorefChain> graph =
                    document.get(CorefCoreAnnotations.CorefChainAnnotation.class);
            System.out.println(graph.values().toString());
        }

    }
}