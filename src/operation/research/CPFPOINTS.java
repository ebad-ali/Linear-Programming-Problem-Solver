/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operation.research;

public class CPFPOINTS {

    private double maximumofz;
    private String maximumcpf;
    private String cpfpointsss;

    public CPFPOINTS(String maximumcpf, double maximumofz) {
        this.maximumcpf = maximumcpf;
        this.maximumofz = maximumofz;
    }

    public CPFPOINTS(String cpfpointsss) {
        this.cpfpointsss = cpfpointsss;
    }

    public String getMaximumcpf() {
        return maximumcpf;
    }
    
    public String getcpfpointsss() {
            return cpfpointsss;
    }

    public double getMaximumofz() {
        return maximumofz;
    }

}
