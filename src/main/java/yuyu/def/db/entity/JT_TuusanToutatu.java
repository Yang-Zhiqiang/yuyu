package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.db.mapping.GenJT_TuusanToutatu;


/**
 * 通算到達テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenJT_TuusanToutatu} の JavaDoc を参照してください。<br />
 * @see     GenJT_TuusanToutatu<br />
 * @see     PKJT_TuusanToutatu<br />
 * @see     QJT_TuusanToutatu<br />
 * @see     GenQJT_TuusanToutatu<br />
 */
@Entity
public class JT_TuusanToutatu extends GenJT_TuusanToutatu {

    private static final long serialVersionUID = 1L;

    public JT_TuusanToutatu() {
    }

    public JT_TuusanToutatu(String pSkno,String pSyono,Integer pSeikyuurirekino,String pKyuuhucd) {
        super(pSkno,pSyono,pSeikyuurirekino,pKyuuhucd);
    }



    private JT_Sk jT_Sk ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=JT_TuusanToutatu.SKNO  , referencedColumnName=JT_Sk.SKNO, insertable=false, updatable=false),
        @JoinColumn(name=JT_TuusanToutatu.SYONO  , referencedColumnName=JT_Sk.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=JT_TuusanToutatu.SEIKYUURIREKINO  , referencedColumnName=JT_Sk.SEIKYUURIREKINO, insertable=false, updatable=false)
    })
    public JT_Sk getSk() {
        return jT_Sk;
    }

    public void setSk(JT_Sk pJT_Sk) {
        this.jT_Sk = pJT_Sk;
    }

}

