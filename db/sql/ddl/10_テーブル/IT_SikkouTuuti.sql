CREATE TABLE IT_SikkouTuuti (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     tyouhyouymd                                        VARCHAR     (8)                                                       NOT NULL  ,  /* 帳票作成日 */
     drtencd                                            VARCHAR     (7)                                                                 ,  /* 代理店コード */
     drtentsinyno                                       VARCHAR     (7)                                                                 ,  /* 代理店通信先郵便番号 */
     drtennmkj                                          VARCHAR     (30)                                                                ,  /* 代理店名（漢字） */
     oyadrtencd                                         VARCHAR     (7)                                                                 ,  /* 親代理店コード */
     oyadrtennmkj                                       VARCHAR     (30)                                                                ,  /* 親代理店名（漢字） */
     tsinyno                                            VARCHAR     (7)                                                                 ,  /* 通信先郵便番号 */
     tsinadr1kj                                         VARCHAR     (30)                                                                ,  /* 通信先住所１（漢字） */
     tsinadr2kj                                         VARCHAR     (30)                                                                ,  /* 通信先住所２（漢字） */
     tsinadr3kj                                         VARCHAR     (30)                                                                ,  /* 通信先住所３（漢字） */
     tsintelno                                          VARCHAR     (14)                                                                ,  /* 通信先電話番号 */
     dai2tsintelno                                      VARCHAR     (14)                                                                ,  /* 第２通信先電話番号 */
     kyknmkj                                            VARCHAR     (15)                                                                ,  /* 契約者名（漢字） */
     hhknnmkj                                           VARCHAR     (15)                                                                ,  /* 被保険者名（漢字） */
     syouhnnm                                           VARCHAR     (40)                                                                ,  /* 商品名 */
     kykymd                                             VARCHAR     (8)                                                                 ,  /* 契約日 */
     hrkkeiro                                           VARCHAR     (2)                                                                 ,  /* 払込経路 */
     hrkkaisuu                                          VARCHAR     (2)                                                                 ,  /* 払込回数 */
     jkipjytym                                          VARCHAR     (6)                                                                 ,  /* 次回Ｐ充当年月 */
     hrkp                                               NUMBER      (13)                                                                ,  /* 払込保険料 */
     hrkp$                                              VARCHAR     (10)                                                                ,  /* 払込保険料(通貨型) */
     sikkouymd                                          VARCHAR     (8)                                                                 ,  /* 失効日 */
     fukkatukigenymd                                    VARCHAR     (8)                                                                 ,  /* 復活期限日 */
     bankcd                                             VARCHAR     (4)                                                                 ,  /* 銀行コード */
     banknmkj                                           VARCHAR     (20)                                                                ,  /* 銀行名（漢字） */
     sitencd                                            VARCHAR     (3)                                                                 ,  /* 支店コード */
     sitennmkj                                          VARCHAR     (20)                                                                ,  /* 支店名（漢字） */
     yokinkbn                                           VARCHAR     (1)                                                                 ,  /* 預金種目区分 */
     kouzano                                            VARCHAR     (12)                                                                ,  /* 口座番号 */
     kzmeiginmkn                                        VARCHAR     (30)                                                                ,  /* 口座名義人氏名（カナ） */
     rcreditcardno                                      VARCHAR     (64)                                                                ,  /* （帳票用）クレジットカード番号 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE IT_SikkouTuuti ADD CONSTRAINT PK_SikkouTuuti PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                    , /* 証券番号 */
     tyouhyouymd                                                /* 帳票作成日 */
) ;

CREATE INDEX IX1_SikkouTuuti ON IT_SikkouTuuti (
     syono                                                    , /* 証券番号 */
     tyouhyouymd                                                /* 帳票作成日 */
) ;
