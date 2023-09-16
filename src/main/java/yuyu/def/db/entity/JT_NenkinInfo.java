package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.db.mapping.GenJT_NenkinInfo;


/**
 * 年金情報テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenJT_NenkinInfo} の JavaDoc を参照してください。<br />
 * @see     GenJT_NenkinInfo<br />
 * @see     PKJT_NenkinInfo<br />
 * @see     QJT_NenkinInfo<br />
 * @see     GenQJT_NenkinInfo<br />
 */
@Entity
public class JT_NenkinInfo extends GenJT_NenkinInfo {

    private static final long serialVersionUID = 1L;

    public JT_NenkinInfo() {
    }

    public JT_NenkinInfo(String pSkno,String pSyono,Integer pSeikyuurirekino) {
        super(pSkno,pSyono,pSeikyuurirekino);
    }



    private JT_Sk jT_Sk ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=JT_NenkinInfo.SKNO  , referencedColumnName=JT_Sk.SKNO, insertable=false, updatable=false),
        @JoinColumn(name=JT_NenkinInfo.SYONO  , referencedColumnName=JT_Sk.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=JT_NenkinInfo.SEIKYUURIREKINO  , referencedColumnName=JT_Sk.SEIKYUURIREKINO, insertable=false, updatable=false)
    })
    public JT_Sk getSk() {
        return jT_Sk;
    }

    public void setSk(JT_Sk pJT_Sk) {
        this.jT_Sk = pJT_Sk;
    }

}

