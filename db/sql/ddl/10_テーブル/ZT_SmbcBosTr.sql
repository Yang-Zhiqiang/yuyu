CREATE TABLE ZT_SmbcBosTr (
     ztrseihowebidkbn                                   VARCHAR     (2)                                                       NOT NULL  ,  /* （取込用）生保ＷｅｂＩＤ区分 */
     ztrseihowebkojincd                                 VARCHAR     (6)                                                       NOT NULL  ,  /* （取込用）生保Ｗｅｂ個人コード */
     ztrseihowebitijihozonhyouji                        VARCHAR     (1)                                                       NOT NULL  ,  /* （取込用）生保Ｗｅｂ一時保存表示 */
     ztrseihowebsekno                                   NUMBER      (3)                                                       NOT NULL  ,  /* （取込用）生保Ｗｅｂ設計書番号 */
     ztrseihowebcalckijyunymd                           VARCHAR     (8)                                                                 ,  /* （取込用）生保Ｗｅｂ計算基準年月日 */
     ztrseihowebhhknknnm                                VARCHAR     (18)                                                                ,  /* （取込用）生保Ｗｅｂ被保険者カナ氏名 */
     ztrseihowebhhknkjnm                                VARCHAR     (11)                                                                ,  /* （取込用）生保Ｗｅｂ被保険者漢字氏名 */
     ztrseihowebhhknseiymd                              VARCHAR     (8)                                                                 ,  /* （取込用）生保Ｗｅｂ被保険者生年月日 */
     ztrseihowebhhknseikbn                              VARCHAR     (1)                                                                 ,  /* （取込用）生保Ｗｅｂ被保険者性別区分 */
     ztrseihowebmrhkihontikucd                          VARCHAR     (8)                                                                 ,  /* （取込用）生保Ｗｅｂマル被基本地区コード */
     ztrseihowebhhknadr                                 VARCHAR     (124)                                                               ,  /* （取込用）生保Ｗｅｂ被保険者住所 */
     ztrseihowebkykknnm                                 VARCHAR     (18)                                                                ,  /* （取込用）生保Ｗｅｂ契約者カナ氏名 */
     ztrseihowebkykkjnm                                 VARCHAR     (11)                                                                ,  /* （取込用）生保Ｗｅｂ契約者漢字氏名 */
     ztrseihowebkyksyaseiymd                            VARCHAR     (8)                                                                 ,  /* （取込用）生保Ｗｅｂ契約者生年月日 */
     ztrseihowebkyksyaseikbn                            VARCHAR     (1)                                                                 ,  /* （取込用）生保Ｗｅｂ契約者性別区分 */
     ztrseihowebkykkihontikucd                          VARCHAR     (8)                                                                 ,  /* （取込用）生保Ｗｅｂ契約者基本地区コード */
     ztrseihowebkykadr                                  VARCHAR     (124)                                                               ,  /* （取込用）生保Ｗｅｂ契約者住所 */
     ztrseihowebhknsyuruino                             VARCHAR     (3)                                                                 ,  /* （取込用）生保Ｗｅｂ保険種類番号 */
     ztrseihowebhjkktkbn                                VARCHAR     (1)                                                                 ,  /* （取込用）生保Ｗｅｂ報状告知区分 */
     ztrseihowebhknkkn                                  NUMBER      (2)                                                                 ,  /* （取込用）生保Ｗｅｂ保険期間 */
     ztrseihowebphrkkikn                                NUMBER      (2)                                                                 ,  /* （取込用）生保ＷｅｂＰ払込期間 */
     ztrseihowebhrkkaisuukbn                            VARCHAR     (1)                                                                 ,  /* （取込用）生保Ｗｅｂ払込回数区分 */
     ztrseihowebhrkkeirokbn                             VARCHAR     (1)                                                                 ,  /* （取込用）生保Ｗｅｂ払込経路区分 */
     ztrseihowebsdpdkbn                                 VARCHAR     (1)                                                                 ,  /* （取込用）生保ＷｅｂＳ建Ｐ建区分 */
     ztrseihowebkihons                                  NUMBER      (9)                                                                 ,  /* （取込用）生保Ｗｅｂ基本Ｓ */
     ztrseihowebnksyuruikbn                             VARCHAR     (1)                                                                 ,  /* （取込用）生保Ｗｅｂ年金種類区分 */
     ztrseihoweblntkkbn                                 VARCHAR     (1)                                                                 ,  /* （取込用）生保ＷｅｂＬＮ特約区分 */
     ztrseihowebnkshrarihyj                             VARCHAR     (1)                                                                 ,  /* （取込用）生保Ｗｅｂ年金支払特約有表示 */
     ztrseihowebmosno                                   VARCHAR     (9)                                                                 ,  /* （取込用）生保Ｗｅｂ申込番号 */
     ztrseihowebsekykkigenymd                           VARCHAR     (8)                                                                 ,  /* （取込用）生保Ｗｅｂ設計書有効期限年月日 */
     ztrseihowebsksjsitencd                             VARCHAR     (4)                                                                 ,  /* （取込用）生保Ｗｅｂ作成時支店コード */
     ztrseihowebsbuktnrkkbn                             VARCHAR     (1)                                                                 ,  /* （取込用）生保Ｗｅｂ死亡受取人入力区分 */
     ztrseihowebsbukttdkkbn                             VARCHAR     (1)                                                                 ,  /* （取込用）生保Ｗｅｂ死亡受取人続柄区分 */
     ztrseihowebsbuktknnm                               VARCHAR     (18)                                                                ,  /* （取込用）生保Ｗｅｂ死亡受取人カナ氏名 */
     ztrseihowebsbuktkjnm                               VARCHAR     (11)                                                                ,  /* （取込用）生保Ｗｅｂ死亡受取人漢字氏名 */
     ztrseihowebsbuktseiymd                             VARCHAR     (8)                                                                 ,  /* （取込用）生保Ｗｅｂ死亡受取人生年月日 */
     ztrseihowebmosprtzmhyj                             VARCHAR     (1)                                                                 ,  /* （取込用）生保Ｗｅｂ申込書印刷済表示 */
     ztrseihowebfstmossksymd                            VARCHAR     (8)                                                                 ,  /* （取込用）生保Ｗｅｂ初回申込書作成年月日 */
     ztrseihowebhnsyukyktdkkbn                          VARCHAR     (1)                                                                 ,  /* （取込用）生保Ｗｅｂ編集後契約者続柄区分 */
     ztrseihowebbsyutrkno                               VARCHAR     (13)                                                                ,  /* （取込用）生保Ｗｅｂ募集人登録番号 */
     ztrseihowebhjnkitikbn                              VARCHAR     (5)                                                                 ,  /* （取込用）生保Ｗｅｂ法人形態区分 */
     ztrseihowebhjnkykhyj                               VARCHAR     (1)                                                                 ,  /* （取込用）生保Ｗｅｂ法人契約表示 */
     ztrseihowebtksykmcd1                               VARCHAR     (2)                                                                 ,  /* （取込用）生保Ｗｅｂ特殊項目コード１ */
     ztrseihowebtksykmcd2                               VARCHAR     (2)                                                                 ,  /* （取込用）生保Ｗｅｂ特殊項目コード２ */
     ztrseihowebtksykmcd3                               VARCHAR     (2)                                                                 ,  /* （取込用）生保Ｗｅｂ特殊項目コード３ */
     ztrseihowebtksykmcd4                               VARCHAR     (2)                                                                 ,  /* （取込用）生保Ｗｅｂ特殊項目コード４ */
     ztrseihowebtksykmcd5                               VARCHAR     (2)                                                                 ,  /* （取込用）生保Ｗｅｂ特殊項目コード５　 */
     ztrseihowebteiwkkn                                 NUMBER      (9)                                                                 ,  /* （取込用）生保Ｗｅｂ低Ｗ期間 */
     ztrseihowebhhkntelno                               VARCHAR     (14)                                                                ,  /* （取込用）生保Ｗｅｂ被保険者電話番号 */
     ztrseihowebkyktelno                                VARCHAR     (14)                                                                ,  /* （取込用）生保Ｗｅｂ契約者電話番号 */
     ztrseihowebknhjnnm                                 VARCHAR     (38)                                                                ,  /* （取込用）生保Ｗｅｂカナ法人名 */
     ztrseihowebkjhjnnm                                 VARCHAR     (30)                                                                ,  /* （取込用）生保Ｗｅｂ漢字法人名 */
     ztrseihowebkndaihyounm                             VARCHAR     (30)                                                                ,  /* （取込用）生保Ｗｅｂカナ代表者名 */
     ztrseihowebkjdaihyounm                             VARCHAR     (30)                                                                ,  /* （取込用）生保Ｗｅｂ漢字代表者名 */
     ztrseihowebdaihyouktgkkbn                          VARCHAR     (2)                                                                 ,  /* （取込用）生保Ｗｅｂ代表者肩書区分 */
     ztrseihowebsykihrkp1                               NUMBER      (10)                                                                ,  /* （取込用）生保Ｗｅｂ初回払込Ｐ１ */
     ztrseihowebmosp1                                   NUMBER      (10)                                                                ,  /* （取込用）生保Ｗｅｂ申込Ｐ１ */
     ztrseihowebtkiyougyoutaikbn                        VARCHAR     (1)                                                                 ,  /* （取込用）生保Ｗｅｂ統計用業態区分 */
     ztrseihowebpaperlessmoshyj                         VARCHAR     (1)                                                                 ,  /* （取込用）生保Ｗｅｂペーパーレス申込表示 */
     ztrseihowebdatasousinzmhyj                         VARCHAR     (1)                                                                 ,  /* （取込用）生保Ｗｅｂデータ送信済表示 */
     ztrseihowebdrtnskno                                VARCHAR     (11)                                                                ,  /* （取込用）生保Ｗｅｂ代理店設計書番号 */
     ztrseihowebsbnksyukbn                              VARCHAR     (1)                                                                 ,  /* （取込用）生保Ｗｅｂ死亡年金種類区分 */
     ztrseihowebaatkisyaknyuucd                         VARCHAR     (4)                                                                 ,  /* （取込用）生保ＷｅｂＡ扱者金融機関コード */
     ztrseihowebkeihidouituhyj                          VARCHAR     (1)                                                                 ,  /* （取込用）生保Ｗｅｂ契被同一表示 */
     ztrseihowebsiteituukakbn                           VARCHAR     (1)                                                                 ,  /* （取込用）生保Ｗｅｂ指定通貨区分 */
     ztrseihowebnykntuukakbn                            VARCHAR     (1)                                                                 ,  /* （取込用）生保Ｗｅｂ入金通貨区分 */
     ztrseihowebtargettkarihyj                          VARCHAR     (1)                                                                 ,  /* （取込用）生保Ｗｅｂターゲット特約有表示 */
     ztrseihowebtargettkkbn                             VARCHAR     (1)                                                                 ,  /* （取込用）生保Ｗｅｂターゲット特約区分 */
     ztrseihowebtargettkmkht                            NUMBER      (3)                                                                 ,  /* （取込用）生保Ｗｅｂターゲット特約目標値 */
     ztrseihowebnykntuukanykngk                         NUMBER      (10)                                                                ,  /* （取込用）生保Ｗｅｂ入金通貨入金額 */
     ztrseihowebnykntukfsthrkp                          NUMBER      (10)                                                                ,  /* （取込用）生保Ｗｅｂ入金通貨初回払込Ｐ */
     ztrseihowebnykntuknexthrkp                         NUMBER      (10)                                                                ,  /* （取込用）生保Ｗｅｂ入金通貨次回払込Ｐ */
     ztrseihowebsaimankihyj                             VARCHAR     (1)                                                                 ,  /* （取込用）生保Ｗｅｂ才満期表示 */
     ztrseihowebrayhyj                                  VARCHAR     (1)                                                                 ,  /* （取込用）生保ＷｅｂＲＡＹ表示 */
     ztrseihowebgnykntuknykngk                          NUMBER      (13)                                                                ,  /* （取込用）生保Ｗｅｂ外貨入金通貨入金額 */
     ztrseihowebgnykntukfsthrkp                         NUMBER      (13)                                                                ,  /* （取込用）生保Ｗｅｂ外貨入金通貨初回Ｐ */
     ztrseihowebgnykntuknxthrkp                         NUMBER      (13)                                                                ,  /* （取込用）生保Ｗｅｂ外貨入金通貨次回Ｐ */
     ztrseihowebgaikakihonp                             NUMBER      (13)                                                                ,  /* （取込用）生保Ｗｅｂ外貨基本Ｐ */
     ztrseihowebkaigmehrtkarihyj                        VARCHAR     (1)                                                                 ,  /* （取込用）生保Ｗｅｂ介護前払特約有表示 */
     ztrseihowebyenhsyutkarihyj                         VARCHAR     (1)                                                                 ,  /* （取込用）生保Ｗｅｂ円最低保証特約有表示 */
     ztrseihowebgaikakihons                             NUMBER      (13)                                                                ,  /* （取込用）生保Ｗｅｂ外貨基本Ｓ */
     ztrseihowebdai1hknkkn                              NUMBER      (2)                                                                 ,  /* （取込用）生保Ｗｅｂ第１保険期間 */
     ztrseihowebkyksykgycd                              VARCHAR     (3)                                                                 ,  /* （取込用）生保Ｗｅｂ契約者職業コード */
     ztrseihowebkknmskhjnkitikbn                        VARCHAR     (2)                                                                 ,  /* （取込用）生保Ｗｅｂ契勤務先法人形態区分 */
     ztrseihowebkykottmsk                               VARCHAR     (60)                                                                ,  /* （取込用）生保Ｗｅｂ契約者お勤め先 */
     ztrseihowebhhknsykgycd                             VARCHAR     (3)                                                                 ,  /* （取込用）生保Ｗｅｂ被保険者職業コード */
     ztrseihowebhknmskhjnkitikbn                        VARCHAR     (2)                                                                 ,  /* （取込用）生保Ｗｅｂ被勤務先法人形態区分 */
     ztrseihowebhhknottmsk                              VARCHAR     (60)                                                                ,  /* （取込用）生保Ｗｅｂ被保険者お勤め先 */
     ztrseihowebhhknnensyuukbn                          VARCHAR     (1)                                                                 ,  /* （取込用）生保Ｗｅｂ被保険者年収区分 */
     ztrseihowebplhhknkjnm                              VARCHAR     (11)                                                                ,  /* （取込用）生保ＷｅｂＰＬ被保険者漢字氏名 */
     ztrseihowebplkykkjnm                               VARCHAR     (11)                                                                ,  /* （取込用）生保ＷｅｂＰＬ契約者漢字氏名 */
     ztrseihowebplhrkkeirokbn                           VARCHAR     (1)                                                                 ,  /* （取込用）生保ＷｅｂＰＬ払込経路区分 */
     ztrseihowebplsbuktnrkkbn                           VARCHAR     (1)                                                                 ,  /* （取込用）生保ＷｅｂＰＬ死亡受入力区分 */
     ztrseihowebplsbukttdkkbn                           VARCHAR     (1)                                                                 ,  /* （取込用）生保ＷｅｂＰＬ死亡受続柄区分 */
     ztrseihowebplsbuktknnm                             VARCHAR     (18)                                                                ,  /* （取込用）生保ＷｅｂＰＬ死亡受カナ氏名 */
     ztrseihowebplsbuktkjnm                             VARCHAR     (11)                                                                ,  /* （取込用）生保ＷｅｂＰＬ死亡受漢字氏名 */
     ztrseihowebplsbuktseiymd                           VARCHAR     (8)                                                                 ,  /* （取込用）生保ＷｅｂＰＬ死亡受生年月日 */
     ztrseihowebplhhkntelno                             VARCHAR     (14)                                                                ,  /* （取込用）生保ＷｅｂＰＬ被保険者電話番号 */
     ztrseihowebplkyktelno                              VARCHAR     (14)                                                                ,  /* （取込用）生保ＷｅｂＰＬ契約者電話番号 */
     ztrseihowebplkihontikucd                           VARCHAR     (8)                                                                 ,  /* （取込用）生保ＷｅｂＰＬ基本地区コード */
     ztrseihowebpltsinadrkai                            VARCHAR     (62)                                                                ,  /* （取込用）生保ＷｅｂＰＬ通信先住所下位 */
     ztrseihowebplhiikihontikucd                        VARCHAR     (8)                                                                 ,  /* （取込用）生保ＷｅｂＰＬ被基本地区コード */
     ztrseihowebplhhknadr                               VARCHAR     (124)                                                               ,  /* （取込用）生保ＷｅｂＰＬ被保険者住所 */
     ztrseihowebhnyppltzmhyj                            VARCHAR     (1)                                                                 ,  /* （取込用）生保Ｗｅｂ汎用ＰＰＬ対応済表示 */
     ztrseihowebssrndhbnwr                              NUMBER      (3)                                                                 ,  /* （取込用）生保Ｗｅｂ指数連動部分配分割合 */
     ztrseihowebtrtrndhbnwr                             NUMBER      (3)                                                                 ,  /* （取込用）生保Ｗｅｂ定率積立部分配分割合 */
     ztrseihowebsueokikkn                               NUMBER      (2)                                                                 ,  /* （取込用）生保Ｗｅｂ据置期間 */
     ztrseihowebmnkuktnrkkbn                            VARCHAR     (1)                                                                 ,  /* （取込用）生保Ｗｅｂ満期受取人入力区分 */
     ztrseihowebmnkukttdkkbn                            VARCHAR     (1)                                                                 ,  /* （取込用）生保Ｗｅｂ満期受取人続柄区分 */
     ztrseihowebmnkuktknnm                              VARCHAR     (18)                                                                ,  /* （取込用）生保Ｗｅｂ満期受取人カナ氏名 */
     ztrseihowebmnkuktkjnm                              VARCHAR     (11)                                                                ,  /* （取込用）生保Ｗｅｂ満期受取人漢字氏名 */
     ztrseihowebmnkuktseiymd                            VARCHAR     (8)                                                                 ,  /* （取込用）生保Ｗｅｂ満期受取人生年月日 */
     ztrseihowebankenkanrino                            VARCHAR     (15)                                                                ,  /* （取込用）生保Ｗｅｂ案件管理番号 */
     ztrseihowebikkatup                                 NUMBER      (10)                                                                ,  /* （取込用）生保Ｗｅｂ一括払Ｐ */
     ztrseihowebikkatubaraikbn                          VARCHAR     (1)                                                                 ,  /* （取込用）生保Ｗｅｂ一括払区分 */
     ztrseihowebiktbrikaisuu                            NUMBER      (2)                                                                 ,  /* （取込用）生保Ｗｅｂ一括払回数 */
     ztrseihowebzennoup                                 NUMBER      (10)                                                                ,  /* （取込用）生保Ｗｅｂ前納Ｐ */
     ztrseihowebgaikazennoup                            NUMBER      (13)                                                                ,  /* （取込用）生保Ｗｅｂ外貨前納Ｐ */
     ztrseihowebzennoukkn                               NUMBER      (2)                                                                 ,  /* （取込用）生保Ｗｅｂ前納期間 */
     ztrseihowebzennouhyj                               VARCHAR     (1)                                                                 ,  /* （取込用）生保Ｗｅｂ前納表示 */
     ztrseihowebkydbosyuukjncd                          VARCHAR     (7)                                                                 ,  /* （取込用）生保Ｗｅｂ共同募集個人コード */
     ztrseihowebkzktrkmoskbn                            VARCHAR     (1)                                                                 ,  /* （取込用）生保Ｗｅｂご家族登録申込区分 */
     ztrseihowebkzktdkkbn1                              VARCHAR     (1)                                                                 ,  /* （取込用）生保Ｗｅｂご家族続柄区分１ */
     ztrseihowebkzkknnm1                                VARCHAR     (18)                                                                ,  /* （取込用）生保Ｗｅｂご家族カナ氏名１ */
     ztrseihowebkzkkjnm1                                VARCHAR     (11)                                                                ,  /* （取込用）生保Ｗｅｂご家族漢字氏名１ */
     ztrseihowebkzkseikbn1                              VARCHAR     (1)                                                                 ,  /* （取込用）生保Ｗｅｂご家族性別区分１ */
     ztrseihowebkzkseiymd1                              VARCHAR     (8)                                                                 ,  /* （取込用）生保Ｗｅｂご家族生年月日１ */
     ztrseihowebkzkkykdoukyohyj1                        VARCHAR     (1)                                                                 ,  /* （取込用）生保Ｗｅｂご家族契同居表示１ */
     ztrseihowebkzkyno1                                 VARCHAR     (8)                                                                 ,  /* （取込用）生保Ｗｅｂご家族郵便番号１ */
     ztrseihowebkzkadr1                                 VARCHAR     (62)                                                                ,  /* （取込用）生保Ｗｅｂご家族住所１ */
     ztrseihowebkzktelno1                               VARCHAR     (14)                                                                ,  /* （取込用）生保Ｗｅｂご家族電話番号１ */
     ztrseihowebkykdrtkkanouhyj                         VARCHAR     (1)                                                                 ,  /* （取込用）生保Ｗｅｂ契代理特約可能表示 */
     ztrseihowebhhkndrtkkanouhyj                        VARCHAR     (1)                                                                 ,  /* （取込用）生保Ｗｅｂ被代理特約可能表示 */
     ztrseihowebdrtkkbn                                 VARCHAR     (1)                                                                 ,  /* （取込用）生保Ｗｅｂ代理特約区分 */
     ztrseihowebkykdrnrkkbn                             VARCHAR     (1)                                                                 ,  /* （取込用）生保Ｗｅｂ契代理入力区分 */
     ztrseihowebhhkndrnrkkbn                            VARCHAR     (1)                                                                 ,  /* （取込用）生保Ｗｅｂ被代理入力区分 */
     ztrseihowebhhkndrtdkkbn                            VARCHAR     (1)                                                                 ,  /* （取込用）生保Ｗｅｂ被代理続柄区分 */
     ztrseihowebhhkndrknnm                              VARCHAR     (18)                                                                ,  /* （取込用）生保Ｗｅｂ被代理カナ氏名 */
     ztrseihowebhhkndrkjnm                              VARCHAR     (11)                                                                ,  /* （取込用）生保Ｗｅｂ被代理漢字氏名 */
     ztrseihowebhhkndrseiymd                            VARCHAR     (8)                                                                 ,  /* （取込用）生保Ｗｅｂ被代理生年月日 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE ZT_SmbcBosTr ADD CONSTRAINT PK_SmbcDairitenSekMosTr PRIMARY KEY (
     ztrseihowebidkbn                                         , /* （取込用）生保ＷｅｂＩＤ区分 */
     ztrseihowebkojincd                                       , /* （取込用）生保Ｗｅｂ個人コード */
     ztrseihowebitijihozonhyouji                              , /* （取込用）生保Ｗｅｂ一時保存表示 */
     ztrseihowebsekno                                           /* （取込用）生保Ｗｅｂ設計書番号 */
) ;

CREATE INDEX IX1_SmbcDairitenSekMosTr ON ZT_SmbcBosTr (
     ztrseihowebfstmossksymd                                    /* （取込用）生保Ｗｅｂ初回申込書作成年月日 */
) ;
