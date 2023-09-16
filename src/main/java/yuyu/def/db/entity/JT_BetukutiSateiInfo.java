package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.db.mapping.GenJT_BetukutiSateiInfo;


/**
 * 別口査定情報テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenJT_BetukutiSateiInfo} の JavaDoc を参照してください。<br />
 * @see     GenJT_BetukutiSateiInfo<br />
 * @see     PKJT_BetukutiSateiInfo<br />
 * @see     QJT_BetukutiSateiInfo<br />
 * @see     GenQJT_BetukutiSateiInfo<br />
 */
@Entity
public class JT_BetukutiSateiInfo extends GenJT_BetukutiSateiInfo {

    private static final long serialVersionUID = 1L;

    public JT_BetukutiSateiInfo() {
    }

    public JT_BetukutiSateiInfo(String pSkno,String pSyono,Integer pSeikyuurirekino) {
        super(pSkno,pSyono,pSeikyuurirekino);
    }



    private JT_Sk jT_Sk ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=JT_BetukutiSateiInfo.SKNO  , referencedColumnName=JT_Sk.SKNO, insertable=false, updatable=false),
        @JoinColumn(name=JT_BetukutiSateiInfo.SYONO  , referencedColumnName=JT_Sk.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=JT_BetukutiSateiInfo.SEIKYUURIREKINO  , referencedColumnName=JT_Sk.SEIKYUURIREKINO, insertable=false, updatable=false)
    })
    public JT_Sk getSk() {
        return jT_Sk;
    }

    public void setSk(JT_Sk pJT_Sk) {
        this.jT_Sk = pJT_Sk;
    }

}

