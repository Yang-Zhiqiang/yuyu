package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.db.mapping.GenJT_SibouSateiChkInfo;


/**
 * 死亡査定チェック情報テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenJT_SibouSateiChkInfo} の JavaDoc を参照してください。<br />
 * @see     GenJT_SibouSateiChkInfo<br />
 * @see     PKJT_SibouSateiChkInfo<br />
 * @see     QJT_SibouSateiChkInfo<br />
 * @see     GenQJT_SibouSateiChkInfo<br />
 */
@Entity
public class JT_SibouSateiChkInfo extends GenJT_SibouSateiChkInfo {

    private static final long serialVersionUID = 1L;

    public JT_SibouSateiChkInfo() {
    }

    public JT_SibouSateiChkInfo(String pSkno,String pSyono,Integer pSeikyuurirekino) {
        super(pSkno,pSyono,pSeikyuurirekino);
    }



    private JT_Sk jT_Sk ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=JT_SibouSateiChkInfo.SKNO  , referencedColumnName=JT_Sk.SKNO, insertable=false, updatable=false),
        @JoinColumn(name=JT_SibouSateiChkInfo.SYONO  , referencedColumnName=JT_Sk.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=JT_SibouSateiChkInfo.SEIKYUURIREKINO  , referencedColumnName=JT_Sk.SEIKYUURIREKINO, insertable=false, updatable=false)
    })
    public JT_Sk getSk() {
        return jT_Sk;
    }

    public void setSk(JT_Sk pJT_Sk) {
        this.jT_Sk = pJT_Sk;
    }

}

