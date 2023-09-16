package yuyu.def.db.entity;

import javax.persistence.Entity;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import yuyu.def.db.mapping.GenJT_SateiJyuukasituChkInfo;

/**
 * 査定重過失チェック情報テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenJT_SateiJyuukasituChkInfo} の JavaDoc を参照してください。<br />
 * @see     GenJT_SateiJyuukasituChkInfo<br />
 * @see     PKJT_SateiJyuukasituChkInfo<br />
 * @see     QJT_SateiJyuukasituChkInfo<br />
 * @see     GenQJT_SateiJyuukasituChkInfo<br />
 */
@Entity
public class JT_SateiJyuukasituChkInfo extends GenJT_SateiJyuukasituChkInfo {

    private static final long serialVersionUID = 1L;

    public JT_SateiJyuukasituChkInfo() {
    }

    public JT_SateiJyuukasituChkInfo(String pSkno,String pSyono,Integer pSeikyuurirekino) {
        super(pSkno,pSyono,pSeikyuurirekino);
    }



    private JT_Sk jT_Sk ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=JT_SateiJyuukasituChkInfo.SKNO  , referencedColumnName=JT_Sk.SKNO, insertable=false, updatable=false),
        @JoinColumn(name=JT_SateiJyuukasituChkInfo.SYONO  , referencedColumnName=JT_Sk.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=JT_SateiJyuukasituChkInfo.SEIKYUURIREKINO  , referencedColumnName=JT_Sk.SEIKYUURIREKINO, insertable=false, updatable=false)
    })
    public JT_Sk getSk() {
        return jT_Sk;
    }

    public void setSk(JT_Sk pJT_Sk) {
        this.jT_Sk = pJT_Sk;
    }

}

