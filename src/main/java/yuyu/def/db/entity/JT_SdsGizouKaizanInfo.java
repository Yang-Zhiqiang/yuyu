package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.db.mapping.GenJT_SdsGizouKaizanInfo;


/**
 * 診断書偽造改竄情報テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenJT_SdsGizouKaizanInfo} の JavaDoc を参照してください。<br />
 * @see     GenJT_SdsGizouKaizanInfo<br />
 * @see     PKJT_SdsGizouKaizanInfo<br />
 * @see     QJT_SdsGizouKaizanInfo<br />
 * @see     GenQJT_SdsGizouKaizanInfo<br />
 */
@Entity
public class JT_SdsGizouKaizanInfo extends GenJT_SdsGizouKaizanInfo {

    private static final long serialVersionUID = 1L;

    public JT_SdsGizouKaizanInfo() {
    }

    public JT_SdsGizouKaizanInfo(String pSkno,String pSyono,Integer pSeikyuurirekino) {
        super(pSkno,pSyono,pSeikyuurirekino);
    }



    private JT_Sk jT_Sk ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=JT_SdsGizouKaizanInfo.SKNO  , referencedColumnName=JT_Sk.SKNO, insertable=false, updatable=false),
        @JoinColumn(name=JT_SdsGizouKaizanInfo.SYONO  , referencedColumnName=JT_Sk.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=JT_SdsGizouKaizanInfo.SEIKYUURIREKINO  , referencedColumnName=JT_Sk.SEIKYUURIREKINO, insertable=false, updatable=false)
    })
    public JT_Sk getSk() {
        return jT_Sk;
    }

    public void setSk(JT_Sk pJT_Sk) {
        this.jT_Sk = pJT_Sk;
    }

}

