package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.db.mapping.GenJT_SateiKaijyoInfo;


/**
 * 査定解除情報テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenJT_SateiKaijyoInfo} の JavaDoc を参照してください。<br />
 * @see     GenJT_SateiKaijyoInfo<br />
 * @see     PKJT_SateiKaijyoInfo<br />
 * @see     QJT_SateiKaijyoInfo<br />
 * @see     GenQJT_SateiKaijyoInfo<br />
 */
@Entity
public class JT_SateiKaijyoInfo extends GenJT_SateiKaijyoInfo {

    private static final long serialVersionUID = 1L;

    public JT_SateiKaijyoInfo() {
    }

    public JT_SateiKaijyoInfo(String pSkno,String pSyono,Integer pSeikyuurirekino) {
        super(pSkno,pSyono,pSeikyuurirekino);
    }



    private JT_Sk jT_Sk ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=JT_SateiKaijyoInfo.SKNO  , referencedColumnName=JT_Sk.SKNO, insertable=false, updatable=false),
        @JoinColumn(name=JT_SateiKaijyoInfo.SYONO  , referencedColumnName=JT_Sk.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=JT_SateiKaijyoInfo.SEIKYUURIREKINO  , referencedColumnName=JT_Sk.SEIKYUURIREKINO, insertable=false, updatable=false)
    })
    public JT_Sk getSk() {
        return jT_Sk;
    }

    public void setSk(JT_Sk pJT_Sk) {
        this.jT_Sk = pJT_Sk;
    }

}

