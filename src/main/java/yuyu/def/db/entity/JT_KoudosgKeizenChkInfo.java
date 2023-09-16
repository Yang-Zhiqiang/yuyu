package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.db.mapping.GenJT_KoudosgKeizenChkInfo;


/**
 * 高度障害契前チェック情報テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenJT_KoudosgKeizenChkInfo} の JavaDoc を参照してください。<br />
 * @see     GenJT_KoudosgKeizenChkInfo<br />
 * @see     PKJT_KoudosgKeizenChkInfo<br />
 * @see     QJT_KoudosgKeizenChkInfo<br />
 * @see     GenQJT_KoudosgKeizenChkInfo<br />
 */
@Entity
public class JT_KoudosgKeizenChkInfo extends GenJT_KoudosgKeizenChkInfo {

    private static final long serialVersionUID = 1L;

    public JT_KoudosgKeizenChkInfo() {
    }

    public JT_KoudosgKeizenChkInfo(String pSkno,String pSyono,Integer pSeikyuurirekino) {
        super(pSkno,pSyono,pSeikyuurirekino);
    }



    private JT_Sk jT_Sk ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=JT_KoudosgKeizenChkInfo.SKNO  , referencedColumnName=JT_Sk.SKNO, insertable=false, updatable=false),
        @JoinColumn(name=JT_KoudosgKeizenChkInfo.SYONO  , referencedColumnName=JT_Sk.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=JT_KoudosgKeizenChkInfo.SEIKYUURIREKINO  , referencedColumnName=JT_Sk.SEIKYUURIREKINO, insertable=false, updatable=false)
    })
    public JT_Sk getSk() {
        return jT_Sk;
    }

    public void setSk(JT_Sk pJT_Sk) {
        this.jT_Sk = pJT_Sk;
    }

}

