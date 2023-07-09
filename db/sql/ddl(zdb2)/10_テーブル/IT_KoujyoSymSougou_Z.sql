CREATE TABLE IT_KoujyoSymSougou_Z (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     nendo                                              VARCHAR     (4)                                                       NOT NULL  ,  /* 年度 */
     kktyhysksitisykbn                                  VARCHAR     (2)                                                                 ,  /* 契約管理帳票作成対象区分 */
     tyouhyouymd                                        VARCHAR     (8)                                                       NOT NULL  ,  /* 帳票作成日 */
     renno                                              DECIMAL     (2)                                                       NOT NULL  ,  /* 連番 */
     tekiyouseidokbn                                    VARCHAR     (1)                                                                 ,  /* 適用制度区分 */
     syoumeiymd                                         VARCHAR     (8)                                                                 ,  /* 証明日 */
     syoumeistartym                                     VARCHAR     (6)                                                                 ,  /* 証明開始年月 */
     syoumeiendym                                       VARCHAR     (6)                                                                 ,  /* 証明終了年月 */
     syoumeikkntukisuu                                  DECIMAL     (2)                                                                 ,  /* 証明期間月数 */
     kyknmkj                                            VARCHAR     (32)                                                                ,  /* 契約者名（漢字） */
     uktnmkj                                            VARCHAR     (32)                                                                ,  /* 受取人名（漢字） */
     hknsyuruinmrykkj                                   VARCHAR     (82)                                                                ,  /* 保険種類略称（漢字） */
     kykymd                                             VARCHAR     (8)                                                                 ,  /* 契約日 */
     hknkknsmnkbnsyu                                    VARCHAR     (1)                                                                 ,  /* 保険期間歳満期区分（主契約） */
     hknkknsyu                                          DECIMAL     (2)                                                                 ,  /* 保険期間（主契約） */
     nenkanhrkkaisuu                                    DECIMAL     (2)                                                                 ,  /* 年間払込回数 */
     kykjyoutai                                         VARCHAR     (2)                                                                 ,  /* 契約状態 */
     yuukousyoumetukbn                                  VARCHAR     (1)                                                                 ,  /* 有効消滅区分 */
     haitouhoukbn                                       VARCHAR     (1)                                                                 ,  /* 配当方法区分 */
     haitoukinuketorihoukbn                             VARCHAR     (1)                                                                 ,  /* 配当金受取方法区分 */
     oldippanjissekip                                   DECIMAL     (13)                                                                ,  /* 旧制度一般実績保険料 */
     oldippanjissekip$                                  VARCHAR     (10)                                                                ,  /* 旧制度一般実績保険料(通貨型) */
     oldippannenkanp                                    DECIMAL     (13)                                                                ,  /* 旧制度一般年間保険料 */
     oldippannenkanp$                                   VARCHAR     (10)                                                                ,  /* 旧制度一般年間保険料(通貨型) */
     oldippanjissekihaitoukin                           DECIMAL     (13)                                                                ,  /* 旧制度一般実績配当金 */
     oldippanjissekihaitoukin$                          VARCHAR     (10)                                                                ,  /* 旧制度一般実績配当金(通貨型) */
     oldippannenkanhaitoukin                            DECIMAL     (13)                                                                ,  /* 旧制度一般年間配当金 */
     oldippannenkanhaitoukin$                           VARCHAR     (10)                                                                ,  /* 旧制度一般年間配当金(通貨型) */
     oldippanjissekisyoumeigk                           DECIMAL     (13)                                                                ,  /* 旧制度一般実績証明額 */
     oldippanjissekisyoumeigk$                          VARCHAR     (10)                                                                ,  /* 旧制度一般実績証明額(通貨型) */
     oldippannenkansyoumeigk                            DECIMAL     (13)                                                                ,  /* 旧制度一般年間証明額 */
     oldippannenkansyoumeigk$                           VARCHAR     (10)                                                                ,  /* 旧制度一般年間証明額(通貨型) */
     newippanjissekip                                   DECIMAL     (13)                                                                ,  /* 新制度一般実績保険料 */
     newippanjissekip$                                  VARCHAR     (10)                                                                ,  /* 新制度一般実績保険料(通貨型) */
     newippannenkanp                                    DECIMAL     (13)                                                                ,  /* 新制度一般年間保険料 */
     newippannenkanp$                                   VARCHAR     (10)                                                                ,  /* 新制度一般年間保険料(通貨型) */
     newippanjissekihaitoukin                           DECIMAL     (13)                                                                ,  /* 新制度一般実績配当金 */
     newippanjissekihaitoukin$                          VARCHAR     (10)                                                                ,  /* 新制度一般実績配当金(通貨型) */
     newippannenkanhaitoukin                            DECIMAL     (13)                                                                ,  /* 新制度一般年間配当金 */
     newippannenkanhaitoukin$                           VARCHAR     (10)                                                                ,  /* 新制度一般年間配当金(通貨型) */
     newippanjissekisyoumeigk                           DECIMAL     (13)                                                                ,  /* 新制度一般実績証明額 */
     newippanjissekisyoumeigk$                          VARCHAR     (10)                                                                ,  /* 新制度一般実績証明額(通貨型) */
     newippannenkansyoumeigk                            DECIMAL     (13)                                                                ,  /* 新制度一般年間証明額 */
     newippannenkansyoumeigk$                           VARCHAR     (10)                                                                ,  /* 新制度一般年間証明額(通貨型) */
     newiryoujissekip                                   DECIMAL     (13)                                                                ,  /* 新制度介護医療実績保険料 */
     newiryoujissekip$                                  VARCHAR     (10)                                                                ,  /* 新制度介護医療実績保険料(通貨型) */
     newiryounenkanp                                    DECIMAL     (13)                                                                ,  /* 新制度介護医療年間保険料 */
     newiryounenkanp$                                   VARCHAR     (10)                                                                ,  /* 新制度介護医療年間保険料(通貨型) */
     newiryoujissekihaitoukin                           DECIMAL     (13)                                                                ,  /* 新制度介護医療実績配当金 */
     newiryoujissekihaitoukin$                          VARCHAR     (10)                                                                ,  /* 新制度介護医療実績配当金(通貨型) */
     newiryounenkanhaitoukin                            DECIMAL     (13)                                                                ,  /* 新制度介護医療年間配当金 */
     newiryounenkanhaitoukin$                           VARCHAR     (10)                                                                ,  /* 新制度介護医療年間配当金(通貨型) */
     newiryoujissekisyoumeigk                           DECIMAL     (13)                                                                ,  /* 新制度介護医療実績証明額 */
     newiryoujissekisyoumeigk$                          VARCHAR     (10)                                                                ,  /* 新制度介護医療実績証明額(通貨型) */
     newiryounenkansyoumeigk                            DECIMAL     (13)                                                                ,  /* 新制度介護医療年間証明額 */
     newiryounenkansyoumeigk$                           VARCHAR     (10)                                                                ,  /* 新制度介護医療年間証明額(通貨型) */
     newnkjissekip                                      DECIMAL     (13)                                                                ,  /* 新制度年金実績保険料 */
     newnkjissekip$                                     VARCHAR     (10)                                                                ,  /* 新制度年金実績保険料(通貨型) */
     newnknenkanp                                       DECIMAL     (13)                                                                ,  /* 新制度年金年間保険料 */
     newnknenkanp$                                      VARCHAR     (10)                                                                ,  /* 新制度年金年間保険料(通貨型) */
     newnkjissekihaitoukin                              DECIMAL     (13)                                                                ,  /* 新制度年金実績配当金 */
     newnkjissekihaitoukin$                             VARCHAR     (10)                                                                ,  /* 新制度年金実績配当金(通貨型) */
     newnknenkanhaitoukin                               DECIMAL     (13)                                                                ,  /* 新制度年金年間配当金 */
     newnknenkanhaitoukin$                              VARCHAR     (10)                                                                ,  /* 新制度年金年間配当金(通貨型) */
     newnkjissekisyoumeigk                              DECIMAL     (13)                                                                ,  /* 新制度年金実績証明額 */
     newnkjissekisyoumeigk$                             VARCHAR     (10)                                                                ,  /* 新制度年金実績証明額(通貨型) */
     newnknenkansyoumeigk                               DECIMAL     (13)                                                                ,  /* 新制度年金年間証明額 */
     newnknenkansyoumeigk$                              VARCHAR     (10)                                                                ,  /* 新制度年金年間証明額(通貨型) */
     rtratkicd                                          DECIMAL     (1)                                                                 ,  /* （帳票用）取扱コード */
     rtyouhyoucd                                        VARCHAR     (4)                                                                 ,  /* （帳票用）帳票コード */
     tyhyrenrakusikibetukbn                             VARCHAR     (2)                                                                 ,  /* 帳票連絡先識別区分 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE IT_KoujyoSymSougou_Z ADD CONSTRAINT PK_KoujyoSymSougou PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                    , /* 証券番号 */
     nendo                                                    , /* 年度 */
     tyouhyouymd                                              , /* 帳票作成日 */
     renno                                                      /* 連番 */
) ;

CREATE INDEX IX1_KoujyoSymSougou ON IT_KoujyoSymSougou_Z (
     syono                                                    , /* 証券番号 */
     nendo                                                    , /* 年度 */
     tyouhyouymd                                              , /* 帳票作成日 */
     renno                                                      /* 連番 */
) ;
