/**
 * Created by Mayanka on 14-Jun-16.
 */
import edu.stanford.nlp.simple.*;

public class SimpleCoreNLP {
    public static void main(String[] args) {
        // Create a document. No computation is done yet.
        Document doc = new Document("      \n" +
                "NAME DESCRIPTION ALL       TA+ Norel ALL     TA+ (ML) Norel ALL      Norel ALL      TA  Norel ALL       TA  Norel ALL       TA  Norel ALL R   (ML) Relap ALL      ML ALL      ML ALL      ML ALL      ML ALL      ML ALL      ML ALL      TA+ (ML) Norel ALL      TA+ (ML) Norel ALL      TA  (ML) Norel ALL      TA  (ML) Norel ALL     TA  (ML) Norel ALL SH   ALL SH    ALL SH    AML    (PK) Norel AML    (PK) Norel AML    (PK) Relap AML   (PK) Relap AML SH   AML SH    AML SH    AML SH    AML SH    AML    ML AML    ML AML    (ML) AML    (ML) AML   (ML) Relap\n" +
                "ALPPL  ALPPL :alkaline phosphatase, placental like                                                                                                                                                                                   \n" +
                "RPLP  RPLP :ribosomal protein, large, P                                                                                                                                                                                                                                                      \n" +
                "GFER GFER:growth factor, augmenter of liver regeneration (ERV  homolog, S  cerevisiae)                                                                                                                                                                            \n" +
                "IGHM IGHM:immunoglobulin heavy constant mu                                                                                                                                                                                                                       \n" +
                "SART  SART :squamous cell carcinoma antigen recognised by T cells                                                                                                                                                                              \n" +
                "RPLP  RPLP :ribosomal protein, large, P                                                                                                                                                                                                                                                      \n" +
                "RPLP  RPLP :ribosomal protein, large, P                                                                                                                                                                                                                                                      \n" +
                "PDHA  PDHA :pyruvate dehydrogenase (lipoamide) alpha                                                                                                                                                 \n" +
                "OGT OGT:O linked N acetylglucosamine (GlcNAc) transferase (UDP N acetylglucosamine:polypeptide N acetylglucosaminyl transferase)                                                                                                                                                                             \n" +
                "PDHA  PDHA :pyruvate dehydrogenase (lipoamide) alpha                                                                                                                                                                                     \n" +
                "CYP D P  /// CYP D  na                                                                                                                                                                                   \n" +
                "ACAA  ACAA :acetyl Coenzyme A acyltransferase   (mitochondrial   oxoacyl Coenzyme A thiolase)                                                                                                                                                                          \n" +
                "TMEFF  TMEFF :transmembrane protein with EGF like and two follistatin like domains                                                                                                                                                             \n" +
                "LRRC  LRRC :leucine rich repeat containing ");
                for (Sentence sent : doc.sentences()) {  // Will iterate over two sentences
            // We're only asking for words -- no need to load any models yet
            System.out.println("The second word of the sentence '" + sent + "' is " + sent.word(1));
            // When we ask for the lemma, it will load and run the part of speech tagger
            System.out.println("The third lemma of the sentence '" + sent + "' is " + sent.lemma(2));
            // When we ask for the parse, it will load and run the parser
            System.out.println("The parse of the sentence '" + sent + "' is " + sent.parse());
            // ...
            System.out.println("The triplet extraction of the sentence '" + sent + "' is " + sent.openie());
        }
    }
}