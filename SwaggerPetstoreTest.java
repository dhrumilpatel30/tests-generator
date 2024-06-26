package tests;


import org.junit.Test;

import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.*;

import io.restassured.http.Header;
import io.restassured.response.Response;

import org.cornutum.tcases.openapi.test.ResponseValidator;

import org.hamcrest.Matcher;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class SwaggerPetstoreTest {

    private ResponseValidator responseValidator = new ResponseValidator( getClass());

    @Test
    public void getPets_TagsDefined_Is_Yes() {
        Response response =
            given()
                .baseUri( forTestServer( "https://petstore.swagger.io/v2"))
                .queryParam( "limit", "-736708634")
                .queryParam( "tags", "")
            .when()
                .request( "GET", "/pets")
            .then()
                .statusCode( isSuccess())
            .extract()
                .response()
                ;

        responseValidator.assertBodyValid( "GET", "/pets", response.statusCode(), response.getContentType(), response.asString());
        responseValidator.assertHeadersValid( "GET", "/pets", response.statusCode(), responseHeaders( response));
    }

    @Test
    public void getPets_TagsDefined_Is_No() {
        Response response =
            given()
                .baseUri( forTestServer( "https://petstore.swagger.io/v2"))
            .when()
                .request( "GET", "/pets")
            .then()
                .statusCode( isSuccess())
            .extract()
                .response()
                ;

        responseValidator.assertBodyValid( "GET", "/pets", response.statusCode(), response.getContentType(), response.asString());
        responseValidator.assertHeadersValid( "GET", "/pets", response.statusCode(), responseHeaders( response));
    }

    @Test
    public void getPets_TagsItemsSize_Is_1() {
        Response response =
            given()
                .baseUri( forTestServer( "https://petstore.swagger.io/v2"))
                .queryParam( "limit", "0")
                .queryParam( "tags", "{]8:B@WipLaQpZO\\HC.>f[a\\e0hOe$")
            .when()
                .request( "GET", "/pets")
            .then()
                .statusCode( isSuccess())
            .extract()
                .response()
                ;

        responseValidator.assertBodyValid( "GET", "/pets", response.statusCode(), response.getContentType(), response.asString());
        responseValidator.assertHeadersValid( "GET", "/pets", response.statusCode(), responseHeaders( response));
    }

    @Test
    public void getPets_TagsItemsSize_Is_Gt_1() {
        Response response =
            given()
                .baseUri( forTestServer( "https://petstore.swagger.io/v2"))
                .queryParam( "tags", "")
                .queryParam( "tags", "A!.mx`@_|MO4J94!eoGhbm@_^d`\"8fsBe Piu36s/+QE@l^99Y^PHQk]C_MKAWz{&nTLw7ny%J{bP3.~,2&ZXdJkiZ7 Z';?PpE{hgs%x}<X2vVQOm$p_Yv6e_xtOH{=R;EzhgvdL{[s[MRg6wQN-FP]\\D^Cx6DP* $@M&45H'Nsx_mR'ax\\-EP2icOR#F0L|}t0@~J`+(Yv\\kUg4u,x~D9wL{.ohEM8e!aX|z\"1$;[HRw[{t`?0JG4+Fb")
                .queryParam( "tags", ",%[;TNyP{'QfM@\\aDa)c|H^q$fvY`Mi>w^y'!swA")
            .when()
                .request( "GET", "/pets")
            .then()
                .statusCode( isSuccess())
            .extract()
                .response()
                ;

        responseValidator.assertBodyValid( "GET", "/pets", response.statusCode(), response.getContentType(), response.asString());
        responseValidator.assertHeadersValid( "GET", "/pets", response.statusCode(), responseHeaders( response));
    }

    @Test
    public void getPets_TagsItemsUnique_Is_No() {
        Response response =
            given()
                .baseUri( forTestServer( "https://petstore.swagger.io/v2"))
                .queryParam( "limit", "497535660")
                .queryParam( "tags", "A].W`L3CNf`ugT1t7C?2ChIKe,t\\HykJMG|nJCppk?eNE$mxs\\R6xrTLOP\"B/B*p4?o^3x]fj&mYseW!a_bI0)!k9U8`a(G$IebE}K2?tuRDN:<$4=fG*!\"m+V8`=?\"4<R@wz^ qxsYC~\"==UJX5p=eL~7I-4{U${aXjr0dC\"h^Q^G+n0b_$R7zT\\dFe*_")
                .queryParam( "tags", "P,a:OV<wP^'U&LYL@L&(Odd0.Xa$nHb]m#L/lGQ1BRid^'|F7LfDU5%AGjR(G<u~E0Wa]n4m~Hi:XY<oI-e1\\!D;2m+=#rvu)Bb!'n#E91wn9U|6^Ie7g?5]")
                .queryParam( "tags", "|jB!Y@e,f8SV[pG=Es/MGmS(\\}IOM)V~$&qH.01\\{caO5gP41OzB9!JL|0?;9Wuc[@F)a*hVH`I}u,lF/plu4{a/P:D=NK!BNWs;-6?UUhp~0_z+l'X'|ExwVbumu0K0;cOO|^QrH;VU*?*oIi3iq<Ua>$^30PwD54?nS-BGyj>M<; Yb-N+<_s%kH7#PIzsDB<a<:dvf2}&I")
                .queryParam( "tags", ":D8[\\W`#bX9NwL'7F<heuwE&^\"d{(<5XK/1P^dQ/b|qKP65tC)}\"?//;0[q~{2$s/@ouFY>!c$NHNqU^`}c[Es0XL('+hKh(]d\"Uh^?>TRL]8rSm<=x;\\NsrMk9cc=]Al[c<6F=5h`wYb+.nz#jB>}wFMN6gzb8?F&4)]c*R|j Pah;RnX+Iv\"=c;v|#Pf83%RtyJ`2.yG,_(gUVB\"wAvCns\"E")
                .queryParam( "tags", "o85@>t(6((,)ykLtgbtVC/:4eYUUNBX>[Zu=&A6GHt|]t22mBB88n6z|d~5a7).wM<4r\\icA~xa<m8n*LY<Hc~nAMYQ1 Uf!-%6lao88\\^0-#28$wx;$v]!,dX8'm&iB3.\"w8hMM#@O+wXG=0eI'8ZsCzb\"@%>YPh!p+7WD(CEs]3mM4[<E>B1a0|?4LT\"C]%b>O=8,f$@gh;Mn[Y`@#`vjy{mkY+)EIk.wMCERwN^']EL%ro=V%ohbH]R&^o8")
                .queryParam( "tags", "|jB!Y@e,f8SV[pG=Es/MGmS(\\}IOM)V~$&qH.01\\{caO5gP41OzB9!JL|0?;9Wuc[@F)a*hVH`I}u,lF/plu4{a/P:D=NK!BNWs;-6?UUhp~0_z+l'X'|ExwVbumu0K0;cOO|^QrH;VU*?*oIi3iq<Ua>$^30PwD54?nS-BGyj>M<; Yb-N+<_s%kH7#PIzsDB<a<:dvf2}&I")
            .when()
                .request( "GET", "/pets")
            .then()
                .statusCode( isSuccess())
            .extract()
                .response()
                ;

        responseValidator.assertBodyValid( "GET", "/pets", response.statusCode(), response.getContentType(), response.asString());
        responseValidator.assertHeadersValid( "GET", "/pets", response.statusCode(), responseHeaders( response));
    }

    @Test
    public void getPets_TagsType_Is_Null() {
        Response response =
            given()
                .baseUri( forTestServer( "https://petstore.swagger.io/v2"))
                .queryParam( "tags", (String) null)
            .when()
                .request( "GET", "/pets")
            .then()
                // tags.Type=null
                .statusCode( isBadRequest())
            .extract()
                .response()
                ;

        responseValidator.assertBodyValid( "GET", "/pets", response.statusCode(), response.getContentType(), response.asString());
        responseValidator.assertHeadersValid( "GET", "/pets", response.statusCode(), responseHeaders( response));
    }

    @Test
    public void getPets_TagsType_Is_NotArray() {
        Response response =
            given()
                .baseUri( forTestServer( "https://petstore.swagger.io/v2"))
                .queryParam( "tags", "978.4")
            .when()
                .request( "GET", "/pets")
            .then()
                // tags.Type=Not array
                .statusCode( isBadRequest())
            .extract()
                .response()
                ;

        responseValidator.assertBodyValid( "GET", "/pets", response.statusCode(), response.getContentType(), response.asString());
        responseValidator.assertHeadersValid( "GET", "/pets", response.statusCode(), responseHeaders( response));
    }

    @Test
    public void getPets_TagsItemsContainsType_Is_Null() {
        Response response =
            given()
                .baseUri( forTestServer( "https://petstore.swagger.io/v2"))
                .queryParam( "tags", (String) null)
            .when()
                .request( "GET", "/pets")
            .then()
                // tags.Items.Contains.Type=null
                .statusCode( isBadRequest())
            .extract()
                .response()
                ;

        responseValidator.assertBodyValid( "GET", "/pets", response.statusCode(), response.getContentType(), response.asString());
        responseValidator.assertHeadersValid( "GET", "/pets", response.statusCode(), responseHeaders( response));
    }

    @Test
    public void getPets_LimitType_Is_Null() {
        Response response =
            given()
                .baseUri( forTestServer( "https://petstore.swagger.io/v2"))
                .queryParam( "limit", (String) null)
            .when()
                .request( "GET", "/pets")
            .then()
                // limit.Type=null
                .statusCode( isBadRequest())
            .extract()
                .response()
                ;

        responseValidator.assertBodyValid( "GET", "/pets", response.statusCode(), response.getContentType(), response.asString());
        responseValidator.assertHeadersValid( "GET", "/pets", response.statusCode(), responseHeaders( response));
    }

    @Test
    public void getPets_LimitType_Is_NotInteger() {
        Response response =
            given()
                .baseUri( forTestServer( "https://petstore.swagger.io/v2"))
                .queryParam( "limit", "397.2")
            .when()
                .request( "GET", "/pets")
            .then()
                // limit.Type=Not integer
                .statusCode( isBadRequest())
            .extract()
                .response()
                ;

        responseValidator.assertBodyValid( "GET", "/pets", response.statusCode(), response.getContentType(), response.asString());
        responseValidator.assertHeadersValid( "GET", "/pets", response.statusCode(), responseHeaders( response));
    }

    @Test
    public void postPets_BodyDefined_Is_Yes() {
        Response response =
            given()
                .baseUri( forTestServer( "https://petstore.swagger.io/v2"))
                .contentType( "application/json")
                .request().body( "{\"name\":\"[dW?x|/HJn)rTa~t-<EevZ8\\\"S~cp{5Oq 8_m|S$4S&$bT=CxV/F7=/c^Pq!K)+]+]* :R;+d+2Mz1`6o/t0V|*V;jhmZ}\\\\H%zjBEc}N8N:}`\",\"tag\":\"Pp/nhFaGn],ie))jrJ|3>P\\\"YA)HG#{cC1Q.N~0~mZP]S_W\\\\3|\",\"ehpggqjdxlxg\":true,\"oooztfnvrlbvuuqj\":808.8}")
            .when()
                .request( "POST", "/pets")
            .then()
                .statusCode( isSuccess())
            .extract()
                .response()
                ;

        responseValidator.assertBodyValid( "POST", "/pets", response.statusCode(), response.getContentType(), response.asString());
        responseValidator.assertHeadersValid( "POST", "/pets", response.statusCode(), responseHeaders( response));
    }

    @Test
    public void postPets_BodyApplicationJsonValuePropertiesNameValueLength_Is_0() {
        Response response =
            given()
                .baseUri( forTestServer( "https://petstore.swagger.io/v2"))
                .contentType( "application/json")
                .request().body( "{\"name\":\"\"}")
            .when()
                .request( "POST", "/pets")
            .then()
                .statusCode( isSuccess())
            .extract()
                .response()
                ;

        responseValidator.assertBodyValid( "POST", "/pets", response.statusCode(), response.getContentType(), response.asString());
        responseValidator.assertHeadersValid( "POST", "/pets", response.statusCode(), responseHeaders( response));
    }

    @Test
    public void postPets_BodyApplicationJsonValuePropertiesTagValueLength_Is_0() {
        Response response =
            given()
                .baseUri( forTestServer( "https://petstore.swagger.io/v2"))
                .contentType( "application/json")
                .request().body( "{\"name\":\"zD\\\"k2:>-WXhut}E&tW]*AM?e5~/{8!oHrv>Sga54U$^9:ln#[eCWMIsSmZ(`Q0%,=D3w\",\"tag\":\"\",\"hakfqxwzq\":true,\"s\":true}")
            .when()
                .request( "POST", "/pets")
            .then()
                .statusCode( isSuccess())
            .extract()
                .response()
                ;

        responseValidator.assertBodyValid( "POST", "/pets", response.statusCode(), response.getContentType(), response.asString());
        responseValidator.assertHeadersValid( "POST", "/pets", response.statusCode(), responseHeaders( response));
    }

    @Test
    public void postPets_BodyDefined_Is_No() {
        Response response =
            given()
                .baseUri( forTestServer( "https://petstore.swagger.io/v2"))
            .when()
                .request( "POST", "/pets")
            .then()
                // Body.Defined=No
                .statusCode( isBadRequest())
            .extract()
                .response()
                ;

        responseValidator.assertBodyValid( "POST", "/pets", response.statusCode(), response.getContentType(), response.asString());
        responseValidator.assertHeadersValid( "POST", "/pets", response.statusCode(), responseHeaders( response));
    }

    @Test
    public void postPets_BodyMediaType_Is_Other() {
        Response response =
            given()
                .baseUri( forTestServer( "https://petstore.swagger.io/v2"))
                .contentType( "text/plain")
                .request().body( "-390")
            .when()
                .request( "POST", "/pets")
            .then()
                // Body.Media-Type=Other
                .statusCode( isBadRequest())
            .extract()
                .response()
                ;

        responseValidator.assertBodyValid( "POST", "/pets", response.statusCode(), response.getContentType(), response.asString());
        responseValidator.assertHeadersValid( "POST", "/pets", response.statusCode(), responseHeaders( response));
    }

    @Test
    public void postPets_BodyApplicationJsonType_Is_Null() {
        Response response =
            given()
                .baseUri( forTestServer( "https://petstore.swagger.io/v2"))
                .contentType( "application/json")
                .request().body( "null")
            .when()
                .request( "POST", "/pets")
            .then()
                // Body.application-json.Type=null
                .statusCode( isBadRequest())
            .extract()
                .response()
                ;

        responseValidator.assertBodyValid( "POST", "/pets", response.statusCode(), response.getContentType(), response.asString());
        responseValidator.assertHeadersValid( "POST", "/pets", response.statusCode(), responseHeaders( response));
    }

    @Test
    public void postPets_BodyApplicationJsonType_Is_NotObject() {
        Response response =
            given()
                .baseUri( forTestServer( "https://petstore.swagger.io/v2"))
                .contentType( "application/json")
                .request().body( "107")
            .when()
                .request( "POST", "/pets")
            .then()
                // Body.application-json.Type=Not object
                .statusCode( isBadRequest())
            .extract()
                .response()
                ;

        responseValidator.assertBodyValid( "POST", "/pets", response.statusCode(), response.getContentType(), response.asString());
        responseValidator.assertHeadersValid( "POST", "/pets", response.statusCode(), responseHeaders( response));
    }

    @Test
    public void postPets_BodyApplicationJsonValuePropertiesNameDefined_Is_No() {
        Response response =
            given()
                .baseUri( forTestServer( "https://petstore.swagger.io/v2"))
                .contentType( "application/json")
                .request().body( "{}")
            .when()
                .request( "POST", "/pets")
            .then()
                // Body.application-json.Value.Properties.name.Defined=No
                .statusCode( isBadRequest())
            .extract()
                .response()
                ;

        responseValidator.assertBodyValid( "POST", "/pets", response.statusCode(), response.getContentType(), response.asString());
        responseValidator.assertHeadersValid( "POST", "/pets", response.statusCode(), responseHeaders( response));
    }

    @Test
    public void postPets_BodyApplicationJsonValuePropertiesNameType_Is_Null() {
        Response response =
            given()
                .baseUri( forTestServer( "https://petstore.swagger.io/v2"))
                .contentType( "application/json")
                .request().body( "{\"name\":null}")
            .when()
                .request( "POST", "/pets")
            .then()
                // Body.application-json.Value.Properties.name.Type=null
                .statusCode( isBadRequest())
            .extract()
                .response()
                ;

        responseValidator.assertBodyValid( "POST", "/pets", response.statusCode(), response.getContentType(), response.asString());
        responseValidator.assertHeadersValid( "POST", "/pets", response.statusCode(), responseHeaders( response));
    }

    @Test
    public void postPets_BodyApplicationJsonValuePropertiesNameType_Is_NotString() {
        Response response =
            given()
                .baseUri( forTestServer( "https://petstore.swagger.io/v2"))
                .contentType( "application/json")
                .request().body( "{\"name\":true}")
            .when()
                .request( "POST", "/pets")
            .then()
                // Body.application-json.Value.Properties.name.Type=Not string
                .statusCode( isBadRequest())
            .extract()
                .response()
                ;

        responseValidator.assertBodyValid( "POST", "/pets", response.statusCode(), response.getContentType(), response.asString());
        responseValidator.assertHeadersValid( "POST", "/pets", response.statusCode(), responseHeaders( response));
    }

    @Test
    public void postPets_BodyApplicationJsonValuePropertiesTagType_Is_Null() {
        Response response =
            given()
                .baseUri( forTestServer( "https://petstore.swagger.io/v2"))
                .contentType( "application/json")
                .request().body( "{\"name\":\"\",\"tag\":null}")
            .when()
                .request( "POST", "/pets")
            .then()
                // Body.application-json.Value.Properties.tag.Type=null
                .statusCode( isBadRequest())
            .extract()
                .response()
                ;

        responseValidator.assertBodyValid( "POST", "/pets", response.statusCode(), response.getContentType(), response.asString());
        responseValidator.assertHeadersValid( "POST", "/pets", response.statusCode(), responseHeaders( response));
    }

    @Test
    public void postPets_BodyApplicationJsonValuePropertiesTagType_Is_NotString() {
        Response response =
            given()
                .baseUri( forTestServer( "https://petstore.swagger.io/v2"))
                .contentType( "application/json")
                .request().body( "{\"name\":\"\",\"tag\":[\"5\",\"zv\"]}")
            .when()
                .request( "POST", "/pets")
            .then()
                // Body.application-json.Value.Properties.tag.Type=Not string
                .statusCode( isBadRequest())
            .extract()
                .response()
                ;

        responseValidator.assertBodyValid( "POST", "/pets", response.statusCode(), response.getContentType(), response.asString());
        responseValidator.assertHeadersValid( "POST", "/pets", response.statusCode(), responseHeaders( response));
    }

    @Test
    public void deletePetsId_IdDefined_Is_Yes() {
        Response response =
            given()
                .baseUri( forTestServer( "https://petstore.swagger.io/v2"))
                .pathParam( "id", "-4319248935907586263")
            .when()
                .request( "DELETE", "/pets/{id}")
            .then()
                .statusCode( isSuccess())
            .extract()
                .response()
                ;

        responseValidator.assertBodyValid( "DELETE", "/pets/{id}", response.statusCode(), response.getContentType(), response.asString());
        responseValidator.assertHeadersValid( "DELETE", "/pets/{id}", response.statusCode(), responseHeaders( response));
    }

    @Test
    public void deletePetsId_IdValue_Is_0() {
        Response response =
            given()
                .baseUri( forTestServer( "https://petstore.swagger.io/v2"))
                .pathParam( "id", "0")
            .when()
                .request( "DELETE", "/pets/{id}")
            .then()
                .statusCode( isSuccess())
            .extract()
                .response()
                ;

        responseValidator.assertBodyValid( "DELETE", "/pets/{id}", response.statusCode(), response.getContentType(), response.asString());
        responseValidator.assertHeadersValid( "DELETE", "/pets/{id}", response.statusCode(), responseHeaders( response));
    }

    @Test
    public void deletePetsId_IdValue_Is_Gt_0() {
        Response response =
            given()
                .baseUri( forTestServer( "https://petstore.swagger.io/v2"))
                .pathParam( "id", "4517233801684106297")
            .when()
                .request( "DELETE", "/pets/{id}")
            .then()
                .statusCode( isSuccess())
            .extract()
                .response()
                ;

        responseValidator.assertBodyValid( "DELETE", "/pets/{id}", response.statusCode(), response.getContentType(), response.asString());
        responseValidator.assertHeadersValid( "DELETE", "/pets/{id}", response.statusCode(), responseHeaders( response));
    }

    @Test
    public void deletePetsId_IdType_Is_Null() {
        Response response =
            given()
                .baseUri( forTestServer( "https://petstore.swagger.io/v2"))
                .pathParam( "id", "")
            .when()
                .request( "DELETE", "/pets/{id}")
            .then()
                // id.Type=null
                .statusCode( isBadRequest())
            .extract()
                .response()
                ;

        responseValidator.assertBodyValid( "DELETE", "/pets/{id}", response.statusCode(), response.getContentType(), response.asString());
        responseValidator.assertHeadersValid( "DELETE", "/pets/{id}", response.statusCode(), responseHeaders( response));
    }

    @Test
    public void deletePetsId_IdType_Is_NotInteger() {
        Response response =
            given()
                .baseUri( forTestServer( "https://petstore.swagger.io/v2"))
                .pathParam( "id", "szopkone,-171,dgarkrpnfyqydz,true")
            .when()
                .request( "DELETE", "/pets/{id}")
            .then()
                // id.Type=Not integer
                .statusCode( isBadRequest())
            .extract()
                .response()
                ;

        responseValidator.assertBodyValid( "DELETE", "/pets/{id}", response.statusCode(), response.getContentType(), response.asString());
        responseValidator.assertHeadersValid( "DELETE", "/pets/{id}", response.statusCode(), responseHeaders( response));
    }

    @Test
    public void getPetsId_IdDefined_Is_Yes() {
        Response response =
            given()
                .baseUri( forTestServer( "https://petstore.swagger.io/v2"))
                .pathParam( "id", "-3083540553285807011")
            .when()
                .request( "GET", "/pets/{id}")
            .then()
                .statusCode( isSuccess())
            .extract()
                .response()
                ;

        responseValidator.assertBodyValid( "GET", "/pets/{id}", response.statusCode(), response.getContentType(), response.asString());
        responseValidator.assertHeadersValid( "GET", "/pets/{id}", response.statusCode(), responseHeaders( response));
    }

    @Test
    public void getPetsId_IdValue_Is_0() {
        Response response =
            given()
                .baseUri( forTestServer( "https://petstore.swagger.io/v2"))
                .pathParam( "id", "0")
            .when()
                .request( "GET", "/pets/{id}")
            .then()
                .statusCode( isSuccess())
            .extract()
                .response()
                ;

        responseValidator.assertBodyValid( "GET", "/pets/{id}", response.statusCode(), response.getContentType(), response.asString());
        responseValidator.assertHeadersValid( "GET", "/pets/{id}", response.statusCode(), responseHeaders( response));
    }

    @Test
    public void getPetsId_IdValue_Is_Gt_0() {
        Response response =
            given()
                .baseUri( forTestServer( "https://petstore.swagger.io/v2"))
                .pathParam( "id", "1321820748972843373")
            .when()
                .request( "GET", "/pets/{id}")
            .then()
                .statusCode( isSuccess())
            .extract()
                .response()
                ;

        responseValidator.assertBodyValid( "GET", "/pets/{id}", response.statusCode(), response.getContentType(), response.asString());
        responseValidator.assertHeadersValid( "GET", "/pets/{id}", response.statusCode(), responseHeaders( response));
    }

    @Test
    public void getPetsId_IdType_Is_Null() {
        Response response =
            given()
                .baseUri( forTestServer( "https://petstore.swagger.io/v2"))
                .pathParam( "id", "")
            .when()
                .request( "GET", "/pets/{id}")
            .then()
                // id.Type=null
                .statusCode( isBadRequest())
            .extract()
                .response()
                ;

        responseValidator.assertBodyValid( "GET", "/pets/{id}", response.statusCode(), response.getContentType(), response.asString());
        responseValidator.assertHeadersValid( "GET", "/pets/{id}", response.statusCode(), responseHeaders( response));
    }

    @Test
    public void getPetsId_IdType_Is_NotInteger() {
        Response response =
            given()
                .baseUri( forTestServer( "https://petstore.swagger.io/v2"))
                .pathParam( "id", "{%0!{[$/,Qwr:y?m,{Z9N")
            .when()
                .request( "GET", "/pets/{id}")
            .then()
                // id.Type=Not integer
                .statusCode( isBadRequest())
            .extract()
                .response()
                ;

        responseValidator.assertBodyValid( "GET", "/pets/{id}", response.statusCode(), response.getContentType(), response.asString());
        responseValidator.assertHeadersValid( "GET", "/pets/{id}", response.statusCode(), responseHeaders( response));
    }

    private static Matcher<Integer> isSuccess() {
        return allOf( greaterThanOrEqualTo(200), lessThan(300));
    }

    private static Matcher<Integer> isBadRequest() {
        return allOf( greaterThanOrEqualTo(400), lessThan(500));
    }

    private static String forTestServer( String defaultUri) {
        String testServer = tcasesApiServer();
        return
            defaultUri == null || !testServer.isEmpty()
            ? testServer
            : defaultUri;
    }

    private static String tcasesApiServer() {
        String uri = System.getProperty( "tcasesApiServer");
        return uri == null? "" : uri.trim();
    }

    private static Map<String,List<String>> responseHeaders( Response response) {
        return
            response.getHeaders().asList().stream()
            .collect( groupingBy( Header::getName, mapping( Header::getValue, toList())));
    }
}
