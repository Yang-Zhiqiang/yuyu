package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.db.mapping.GenJT_Toriatukaifuryouinfo;


/**
 * 取扱不良情報テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenJT_Toriatukaifuryouinfo} の JavaDoc を参照してください。<br />
 * @see     GenJT_Toriatukaifuryouinfo<br />
 * @see     PKJT_Toriatukaifuryouinfo<br />
 * @see     QJT_Toriatukaifuryouinfo<br />
 * @see     GenQJT_Toriatukaifuryouinfo<br />
 */
@Entity
public class JT_Toriatukaifuryouinfo extends GenJT_Toriatukaifuryouinfo {

    private static final long serialVersionUID = 1L;

    public JT_Toriatukaifuryouinfo() {
    }

    public JT_Toriatukaifuryouinfo(String pSkno,String pSyono,Integer pSeikyuurirekino) {
        super(pSkno,pSyono,pSeikyuurirekino);
    }



    private JT_Sk jT_Sk ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=JT_Toriatukaifuryouinfo.SKNO  , referencedColumnName=JT_Sk.SKNO, insertable=false, updatable=false),
        @JoinColumn(name=JT_Toriatukaifuryouinfo.SYONO  , referencedColumnName=JT_Sk.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=JT_Toriatukaifuryouinfo.SEIKYUURIREKINO  , referencedColumnName=JT_Sk.SEIKYUURIREKINO, insertable=false, updatable=false)
    })
    public JT_Sk getSk() {
        return jT_Sk;
    }

    public void setSk(JT_Sk pJT_Sk) {
        this.jT_Sk = pJT_Sk;
    }

}

