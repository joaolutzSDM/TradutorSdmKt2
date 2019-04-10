package br.edu.ifsp.scl.sdm.tradutorsdmkt

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.widget.ArrayAdapter
import br.edu.ifsp.scl.sdm.tradutorsdmkt.MainActivity.codigosMensagen.RESPOSTA_TRADUCAO
import br.edu.ifsp.scl.sdm.tradutorsdmkt.model.Language
import br.edu.ifsp.scl.sdm.tradutorsdmkt.volley.Tradutor
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.design.snackbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Instancia o handler da thread de UI usado pelo tradutor
        tradutoHandler = TradutoHandler()

        val tradutor: Tradutor = Tradutor(this)
        tradutor.getLanguages()

        // Seta o Listener para o botão
//        traduzirBt.setOnClickListener {
//            // Testa se o usuário digitou alguma coisa para traduzir
//            if (originalEt.text.isNotEmpty()) {
//                // Instancia um tradutor para fazer a chamada ao WS
//                val tradutor: Tradutor = Tradutor(this)
//                // Solicita a tradução com base nos parâmetros selecionados pelo usuário
//                tradutor.traduzir(originalEt.text.toString(),
//                    idiomaOrigemSp.selectedItem.toString(),
//                    idiomaDestinoSp.selectedItem.toString())
//            }
//            else {
//                // Senão, mostra uma mensagem na parte debaixo do LinearLayout
//                mainLl.snackbar("É preciso digitar uma palavra para ser traduzida")
//            }
//        }
    }

    object codigosMensagen {
        // Constante usada para envio de mensagens ao Handler
        val RESPOSTA_TRADUCAO = 0
    }
    // Idiomas de origem e destino. Dependem da API do Oxford Dict.
    val idiomas = listOf("pt", "en")
    // Handler da thread de UI
    lateinit var tradutoHandler: TradutoHandler
    inner class TradutoHandler: Handler() {
        override fun handleMessage(msg: Message?) {
        if (msg?.what == RESPOSTA_TRADUCAO) {
            // Preenche o spinner com o retorno do WS
            idiomasSp.adapter = ArrayAdapter(
                this@MainActivity,
                android.R.layout.simple_spinner_item,
                msg.obj as MutableList<String>
            )
            idiomasSp.setSelection(0) //pt
        }
    }
    }


}
