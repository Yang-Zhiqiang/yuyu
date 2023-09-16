package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.db.mapping.GenJT_SateiMeigihenkouInfo;


/**
 * 査定名義変更情報テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenJT_SateiMeigihenkouInfo} の JavaDoc を参照してください。<br />
 * @see     GenJT_SateiMeigihenkouInfo<br />
 * @see     PKJT_SateiMeigihenkouInfo<br />
 * @see     QJT_SateiMeigihenkouInfo<br />
 * @see     GenQJT_SateiMeigihenkouInfo<br />
 */
@Entity
public class JT_SateiMeigihenkouInfo extends GenJT_SateiMeigihenkouInfo {

    private static final long serialVersionUID = 1L;

    public JT_SateiMeigihenkouInfo() {
    }

    public JT_SateiMeigihenkouInfo(String pSkno,String pSyono,Integer pSeikyuurirekino) {
        super(pSkno,pSyono,pSeikyuurirekino);
    }



    private JT_Sk jT_Sk ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=JT_SateiMeigihenkouInfo.SKNO  , referencedColumnName=JT_Sk.SKNO, insertable=false, updatable=false),
        @JoinColumn(name=JT_SateiMeigihenkouInfo.SYONO  , referencedColumnName=JT_Sk.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=JT_SateiMeigihenkouInfo.SEIKYUURIREKINO  , referencedColumnName=JT_Sk.SEIKYUURIREKINO, insertable=false, updatable=false)
    })
    public JT_Sk getSk() {
        return jT_Sk;
    }

    public void setSk(JT_Sk pJT_Sk) {
        this.jT_Sk = pJT_Sk;
    }

}

