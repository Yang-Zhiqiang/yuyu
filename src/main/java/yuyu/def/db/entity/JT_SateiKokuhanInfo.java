package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.db.mapping.GenJT_SateiKokuhanInfo;


/**
 * 査定告反情報テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenJT_SateiKokuhanInfo} の JavaDoc を参照してください。<br />
 * @see     GenJT_SateiKokuhanInfo<br />
 * @see     PKJT_SateiKokuhanInfo<br />
 * @see     QJT_SateiKokuhanInfo<br />
 * @see     GenQJT_SateiKokuhanInfo<br />
 */
@Entity
public class JT_SateiKokuhanInfo extends GenJT_SateiKokuhanInfo {

    private static final long serialVersionUID = 1L;

    public JT_SateiKokuhanInfo() {
    }

    public JT_SateiKokuhanInfo(String pSkno,String pSyono,Integer pSeikyuurirekino) {
        super(pSkno,pSyono,pSeikyuurirekino);
    }



    private JT_Sk jT_Sk ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=JT_SateiKokuhanInfo.SKNO  , referencedColumnName=JT_Sk.SKNO, insertable=false, updatable=false),
        @JoinColumn(name=JT_SateiKokuhanInfo.SYONO  , referencedColumnName=JT_Sk.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=JT_SateiKokuhanInfo.SEIKYUURIREKINO  , referencedColumnName=JT_Sk.SEIKYUURIREKINO, insertable=false, updatable=false)
    })
    public JT_Sk getSk() {
        return jT_Sk;
    }

    public void setSk(JT_Sk pJT_Sk) {
        this.jT_Sk = pJT_Sk;
    }

}

