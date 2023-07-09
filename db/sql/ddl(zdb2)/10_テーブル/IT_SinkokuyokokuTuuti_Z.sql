CREATE TABLE IT_SinkokuyokokuTuuti_Z (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     nendo                                              VARCHAR     (4)                                                       NOT NULL  ,  /* 年度 */
     tyouhyouymd                                        VARCHAR     (8)                                                       NOT NULL  ,  /* 帳票作成日 */
     renno                                              DECIMAL     (2)                                                       NOT NULL  ,  /* 連番 */
     syoruiCd                                           VARCHAR     (5)                                                                 ,  /* 書類コード */
     hassoukbn                                          VARCHAR     (1)                                                                 ,  /* 発送区分 */
     tsinyno                                            VARCHAR     (7)                                                                 ,  /* 通信先郵便番号 */
     tsinadr1kj                                         VARCHAR     (62)                                                                ,  /* 通信先住所１（漢字） */
     tsinadr2kj                                         VARCHAR     (62)                                                                ,  /* 通信先住所２（漢字） */
     tsinadr3kj                                         VARCHAR     (62)                                                                ,  /* 通信先住所３（漢字） */
     toiawasesosikinmkj                                 VARCHAR     (32)                                                                ,  /* 問合せ先組織名（漢字） */
     toiawaseyno                                        VARCHAR     (8)                                                                 ,  /* 問合せ先郵便番号 */
     toiawaseadr1kj                                     VARCHAR     (32)                                                                ,  /* 問合せ先住所１（漢字） */
     toiawaseadr2kj                                     VARCHAR     (32)                                                                ,  /* 問合せ先住所２（漢字） */
     toiawaseadr3kj                                     VARCHAR     (32)                                                                ,  /* 問合せ先住所３（漢字） */
     toiawasetelno                                      VARCHAR     (14)                                                                ,  /* 問合せ先電話番号 */
     toiawaseteluktkkanou1                              VARCHAR     (38)                                                                ,  /* 問合せ先電話受付可能時間１ */
     toiawaseteluktkkanou2                              VARCHAR     (38)                                                                ,  /* 問合せ先電話受付可能時間２ */
     toiawasesosikinmkj2                                VARCHAR     (32)                                                                ,  /* 第２問合せ先組織名（漢字） */
     toiawasetelno2                                     VARCHAR     (14)                                                                ,  /* 第２問合せ先電話番号 */
     aisatumongon32keta1                                VARCHAR     (66)                                                                ,  /* 挨拶文言（３２桁）１ */
     aisatumongon32keta2                                VARCHAR     (66)                                                                ,  /* 挨拶文言（３２桁）２ */
     aisatumongon32keta3                                VARCHAR     (66)                                                                ,  /* 挨拶文言（３２桁）３ */
     kyknmkj                                            VARCHAR     (32)                                                                ,  /* 契約者名（漢字） */
     sinkokunen                                         VARCHAR     (4)                                                                 ,  /* 申告年 */
     midasi1                                            VARCHAR     (18)                                                                ,  /* 見出し１ */
     midasi2                                            VARCHAR     (18)                                                                ,  /* 見出し２ */
     midasi3                                            VARCHAR     (18)                                                                ,  /* 見出し３ */
     midasi4                                            VARCHAR     (18)                                                                ,  /* 見出し４ */
     midasi5                                            VARCHAR     (18)                                                                ,  /* 見出し５ */
     midasi6                                            VARCHAR     (18)                                                                ,  /* 見出し６ */
     midasi7                                            VARCHAR     (18)                                                                ,  /* 見出し７ */
     kihonjouhoumongon1                                 VARCHAR     (36)                                                                ,  /* 基本情報文言１ */
     kihonjouhoumongon2                                 VARCHAR     (36)                                                                ,  /* 基本情報文言２ */
     kihonjouhoumongon3                                 VARCHAR     (36)                                                                ,  /* 基本情報文言３ */
     kihonjouhoumongon4                                 VARCHAR     (36)                                                                ,  /* 基本情報文言４ */
     kihonjouhoumongon5                                 VARCHAR     (36)                                                                ,  /* 基本情報文言５ */
     kihonjouhoumongon6                                 VARCHAR     (36)                                                                ,  /* 基本情報文言６ */
     kihonjouhoumongon7                                 VARCHAR     (36)                                                                ,  /* 基本情報文言７ */
     newippanykkp                                       DECIMAL     (13)                                                                ,  /* 新制度一般予告保険料 */
     newippanykkp$                                      VARCHAR     (10)                                                                ,  /* 新制度一般予告保険料(通貨型) */
     newippanykkhaitoukin                               DECIMAL     (13)                                                                ,  /* 新制度一般予告配当金 */
     newippanykkhaitoukin$                              VARCHAR     (10)                                                                ,  /* 新制度一般予告配当金(通貨型) */
     newippanykksyoumeigk                               DECIMAL     (13)                                                                ,  /* 新制度一般予告証明額 */
     newippanykksyoumeigk$                              VARCHAR     (10)                                                                ,  /* 新制度一般予告証明額(通貨型) */
     newiryouykkp                                       DECIMAL     (13)                                                                ,  /* 新制度介護医療予告保険料 */
     newiryouykkp$                                      VARCHAR     (10)                                                                ,  /* 新制度介護医療予告保険料(通貨型) */
     newiryouykkhaitoukin                               DECIMAL     (13)                                                                ,  /* 新制度介護医療予告配当金 */
     newiryouykkhaitoukin$                              VARCHAR     (10)                                                                ,  /* 新制度介護医療予告配当金(通貨型) */
     newiryouykksyoumeigk                               DECIMAL     (13)                                                                ,  /* 新制度介護医療予告証明額 */
     newiryouykksyoumeigk$                              VARCHAR     (10)                                                                ,  /* 新制度介護医療予告証明額(通貨型) */
     newnenkinykkp                                      DECIMAL     (13)                                                                ,  /* 新制度年金予告保険料 */
     newnenkinykkp$                                     VARCHAR     (10)                                                                ,  /* 新制度年金予告保険料(通貨型) */
     newnenkinykkhaitoukin                              DECIMAL     (13)                                                                ,  /* 新制度年金予告配当金 */
     newnenkinykkhaitoukin$                             VARCHAR     (10)                                                                ,  /* 新制度年金予告配当金(通貨型) */
     newnenkinykksyoumeigk                              DECIMAL     (13)                                                                ,  /* 新制度年金予告証明額 */
     newnenkinykksyoumeigk$                             VARCHAR     (10)                                                                ,  /* 新制度年金予告証明額(通貨型) */
     hknjyutoukikan                                     VARCHAR     (38)                                                                ,  /* （帳票用）保険料充当期間 */
     kykymd                                             VARCHAR     (8)                                                                 ,  /* 契約日 */
     hrkkaisuu                                          VARCHAR     (2)                                                                 ,  /* 払込回数 */
     goryuuinm                                          VARCHAR     (62)                                                                ,  /* ご留意メッセージ名称 */
     goryuuimsg1                                        VARCHAR     (68)                                                                ,  /* ご留意メッセージ１ */
     goryuuimsg2                                        VARCHAR     (68)                                                                ,  /* ご留意メッセージ２ */
     goryuuimsg3                                        VARCHAR     (68)                                                                ,  /* ご留意メッセージ３ */
     goryuuimsg4                                        VARCHAR     (68)                                                                ,  /* ご留意メッセージ４ */
     goryuuimsg5                                        VARCHAR     (68)                                                                ,  /* ご留意メッセージ５ */
     goryuuimsg6                                        VARCHAR     (68)                                                                ,  /* ご留意メッセージ６ */
     goryuuimsg7                                        VARCHAR     (68)                                                                ,  /* ご留意メッセージ７ */
     goryuuimsg8                                        VARCHAR     (68)                                                                ,  /* ご留意メッセージ８ */
     goryuuimsg9                                        VARCHAR     (68)                                                                ,  /* ご留意メッセージ９ */
     freearea32keta1                                    VARCHAR     (66)                                                                ,  /* フリーエリア（３２桁）１ */
     freearea32keta2                                    VARCHAR     (66)                                                                ,  /* フリーエリア（３２桁）２ */
     freearea32keta3                                    VARCHAR     (66)                                                                ,  /* フリーエリア（３２桁）３ */
     freearea32keta4                                    VARCHAR     (66)                                                                ,  /* フリーエリア（３２桁）４ */
     freearea32keta5                                    VARCHAR     (66)                                                                ,  /* フリーエリア（３２桁）５ */
     kaiseimsgnm                                        VARCHAR     (42)                                                                ,  /* 改正メッセージ名称 */
     kaiseimsg1                                         VARCHAR     (70)                                                                ,  /* 改正メッセージ１ */
     kaiseimsg2                                         VARCHAR     (70)                                                                ,  /* 改正メッセージ２ */
     kaiseimsg3                                         VARCHAR     (70)                                                                ,  /* 改正メッセージ３ */
     kaiseimsg4                                         VARCHAR     (70)                                                                ,  /* 改正メッセージ４ */
     kaiseimsg5                                         VARCHAR     (70)                                                                ,  /* 改正メッセージ５ */
     kaiseimsg6                                         VARCHAR     (70)                                                                ,  /* 改正メッセージ６ */
     kaiseimsg7                                         VARCHAR     (70)                                                                ,  /* 改正メッセージ７ */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE IT_SinkokuyokokuTuuti_Z ADD CONSTRAINT PK_SinkokuyokokuTuuti PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                    , /* 証券番号 */
     nendo                                                    , /* 年度 */
     tyouhyouymd                                              , /* 帳票作成日 */
     renno                                                      /* 連番 */
) ;

CREATE INDEX IX1_SinkokuyokokuTuuti ON IT_SinkokuyokokuTuuti_Z (
     syono                                                    , /* 証券番号 */
     nendo                                                    , /* 年度 */
     tyouhyouymd                                              , /* 帳票作成日 */
     renno                                                      /* 連番 */
) ;
