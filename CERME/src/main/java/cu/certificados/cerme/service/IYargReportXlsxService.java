package cu.certificados.cerme.service;

import java.io.IOException;
import java.util.Map;

public interface IYargReportXlsxService
{
    public byte[] renderMergedOutputModel(Map<String, Object> model)
            throws IOException;
}