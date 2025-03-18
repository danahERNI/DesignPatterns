// Proxy.ts

interface Website {
    receive(clientIP: string): void;
  }
  
  class RealWebsite implements Website {
    receive(clientIP: string): void {
      console.log("Received request from " + clientIP);
    }
  }
  
  class ProxyServer implements Website {
    private realWebsite: RealWebsite = new RealWebsite();
    private proxyIP: string = "420.68.21.69";
  
    receive(clientIP: string): void {
      console.log("Forwarding request to website using proxy IP: " + this.proxyIP);
      this.realWebsite.receive(this.proxyIP);
    }
  }
  
  (function main(): void {
    const website: Website = new ProxyServer();
    const ip = "192.168.0.1";
    website.receive(ip);
  })();
  