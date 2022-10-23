# Commons-Text Goat

This is a webapp that is intentionally vulnerable to [CVE-2022-42889](https://nvd.nist.gov/vuln/detail/CVE-2022-42889).

It uses an embedded Jetty server and Maven to start a servlet listening at port `8080` at URL `\api`. This endpoint accepts a URL parameter `cmd`. This is embedded between `${` and `}` and passed to the `StringSubstitutor` function; which inturn implements the [StringLookupFactory](https://commons.apache.org/proper/commons-text/apidocs/org/apache/commons/text/lookup/StringLookupFactory.html).

The vulnerability exists because the `StringLookupFactory` includes interpolators that can be can be easily exploited if provided untrusted input. These are `script`, `dns` and `url`. They have been disabled by default since v1.10.0 `coomons-text` versions 1.5 and above till v1.10 are affected.

You can run this locally by executing this command:

```
mvn package exec:java
```

> Note: The program listens on `0.0.0.0` by default. So, don't run this while connected to a untrusted network.
