package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.db.mapping.GenJT_SkHubiMsg;


/**
 * 請求不備テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenJT_SkHubiMsg} の JavaDoc を参照してください。<br />
 * @see     GenJT_SkHubiMsg<br />
 * @see     PKJT_SkHubiMsg<br />
 * @see     QJT_SkHubiMsg<br />
 * @see     GenQJT_SkHubiMsg<br />
 */
@Entity
public class JT_SkHubiMsg extends GenJT_SkHubiMsg {

    private static final long serialVersionUID = 1L;

    public JT_SkHubiMsg() {
    }

    public JT_SkHubiMsg(String pSkno,String pSyono,Integer pSeikyuurirekino,Integer pRenno3keta) {
        super(pSkno,pSyono,pSeikyuurirekino,pRenno3keta);
    }



    private JT_Sk jT_Sk ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=JT_SkHubiMsg.SKNO  , referencedColumnName=JT_Sk.SKNO, insertable=false, updatable=false),
        @JoinColumn(name=JT_SkHubiMsg.SYONO  , referencedColumnName=JT_Sk.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=JT_SkHubiMsg.SEIKYUURIREKINO  , referencedColumnName=JT_Sk.SEIKYUURIREKINO, insertable=false, updatable=false)
    })
    public JT_Sk getSk() {
        return jT_Sk;
    }

    public void setSk(JT_Sk pJT_Sk) {
        this.jT_Sk = pJT_Sk;
    }

}

